package com.neu.customermanagement.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neu.customermanagement.management.dto.Role;
import com.neu.customermanagement.management.entity.Employee;
import com.neu.customermanagement.management.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomJsonLoginFilter extends AbstractAuthenticationProcessingFilter {
    private IEmployeeService iEmployeeService;

    protected CustomJsonLoginFilter(String defaultFilterProcessesUrl, IEmployeeService iEmployeeService) {
        super(defaultFilterProcessesUrl);
        this.iEmployeeService=iEmployeeService;
    }



    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {

        JSONObject jsonObject=transformDataJsonToOjbect(httpServletRequest);
        System.out.println(jsonObject);

        String username= jsonObject.getString("username");
        String password= jsonObject.getString("password");


        System.out.println("**********************username:"+username+",password:"+password);

        System.out.println();
        validateUserPassword(username,password);

        List<Role> list= iEmployeeService.getRoleById(username);
        List<SimpleGrantedAuthority> simpleGrantedAuthoritylist=new ArrayList<>();
        for(Role r:list){
            simpleGrantedAuthoritylist.add(new SimpleGrantedAuthority(r.getPosId()));
        }

        return new UsernamePasswordAuthenticationToken(username,password,simpleGrantedAuthoritylist);
    }


    public  JSONObject transformDataJsonToOjbect(HttpServletRequest httpServletRequest) throws IOException{

        InputStream inputStream= httpServletRequest.getInputStream();
        StringBuilder sb=new StringBuilder();
        byte[] byteArray=new byte[1024];
        int len=0;
        while((len=inputStream.read(byteArray))!=-1){
            sb.append(new String(byteArray,0,len));
        }
        JSONObject jsonObject= JSON.parseObject(sb.toString());

        return  jsonObject;

    }




    public void validateUserPassword(String username,String password){
        // get data from database
        Employee employee=iEmployeeService.getOne(Wrappers.<Employee>lambdaQuery().eq(Employee::getEmpId,username));

        if(employee==null){

            throw new UsernameNotFoundException("username wrong!");
        }
        if(!EncryptionAlgorithm.ENCODER_MAP.get("bcrypt").matches(password, employee.getEmpPassword())){

            throw new AuthenticationServiceException("password wrong!");
        }

    }




}
