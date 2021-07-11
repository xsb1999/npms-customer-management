package com.neu.customermanagement.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neu.customermanagement.management.dto.common.RespBean;
import com.neu.customermanagement.management.entity.Employee;
import com.neu.customermanagement.management.service.IEmployeeService;
import com.neu.customermanagement.util.SpringUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    IEmployeeService iEmployeeService = SpringUtil.getBean(IEmployeeService.class);

    //	当访问成功后 向前台返回的json字符串 封装到 response中
//	这里 就像我们学的servlet一样  有request，response
//	除此之外还有 我们进行认证时候的信息authentication
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter pw=response.getWriter();

        authentication.getCredentials();
        authentication.getDetails();
        System.out.println("authentication.getPrincipal().toString():"+authentication.getPrincipal().toString());

        Employee e=new Employee();
        e.setEmpId(authentication.getPrincipal().toString());
        String a = authentication.getPrincipal().toString();

        String emp_name = iEmployeeService.getEmpNameById(authentication.getPrincipal().toString());
        e.setEmpName(emp_name);
        e.setEmpPositionId(authentication.getAuthorities().toArray()[0].toString());

        RespBean ok = RespBean.ok(1001, "login successful", e);

        pw.print(new ObjectMapper().writeValueAsString(ok));
        pw.flush();
        pw.close();

    }
}
