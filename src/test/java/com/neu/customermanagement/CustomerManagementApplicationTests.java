package com.neu.customermanagement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neu.customermanagement.management.dto.CusManagePageInfo;
import com.neu.customermanagement.management.dto.DeptInfo;
import com.neu.customermanagement.management.dto.EmpInfo;
import com.neu.customermanagement.management.dto.Role;
import com.neu.customermanagement.management.entity.Contact;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.mapper.ContactMapper;
import com.neu.customermanagement.management.mapper.CustomerMapper;
import com.neu.customermanagement.management.mapper.EmployeeMapper;
import com.neu.customermanagement.management.service.ICustomerService;
import com.neu.customermanagement.management.service.IEmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CustomerManagementApplicationTests {

    @Test
    void contextLoads() {
    }


    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    IEmployeeService iEmployeeService;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    ICustomerService iCustomerService;

    @Autowired
    ContactMapper contactMapper;



    @Test
    public void test1(){
        List<Role> list = employeeMapper.getRoleById("800123");
        System.out.println(list.get(0));
    }

    @Test
    public void test2(){
        String s = iEmployeeService.getEmpNameById("800123");
        System.out.println(s);
    }

    @Test
    public void test3(){
        String s = employeeMapper.getDeptNameById("8021110");
        System.out.println(s);
    }

    @Test
    public void test4(){
        List<DeptInfo> deptInfoList = customerMapper.getDeptInfoByEmpId(null);
        System.out.println(deptInfoList);
    }

    @Test
    public void test5(){
        List<EmpInfo> empInfoList = customerMapper.getEmpInfoByEmpIdAndDeptId("800126",null);
        System.out.println(empInfoList);
    }

    @Test
    public void test6(){
        CusManagePageInfo cusManagePageInfo = iCustomerService.getCusManagePageInfo("800125", "30000010");
        System.out.println(cusManagePageInfo);
    }

    @Test
    public void test7(){
        List<EmpInfo> empInfoList = iCustomerService.getEmpByDept("8021140");
        System.out.println(empInfoList);
    }

    @Test
    public void test8(){
        QueryWrapper<Contact> qw = Wrappers.query();
        qw.eq("con_customer_id", "800001");
        List<Contact> contactList = contactMapper.selectList(qw);
        System.out.println(contactList);
    }

    @Test
    public void test9(){
        System.out.println(customerMapper.getRelationByCusId("800001"));
    }

    @Test
    public void test10(){
        System.out.println(customerMapper.getCusNameByCusId("800001"));
    }

    @Test
    public void test11(){
        System.out.println(iCustomerService.getCusDetail("800001"));
    }

    @Test
    public void test12(){
        System.out.println(customerMapper.getEmpInfoByEmpIdAndDeptId(null,"8021140"));
    }

    @Test
    public void test13(){
        System.out.println(iCustomerService.getCusManagePageInfo("800125","30000010"));
    }

}
