package com.neu.customermanagement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neu.customermanagement.management.dto.customer.AddCustomerInfo;
import com.neu.customermanagement.management.dto.customer.CusManagePageInfo;
import com.neu.customermanagement.management.dto.common.DeptInfo;
import com.neu.customermanagement.management.dto.common.EmpInfo;
import com.neu.customermanagement.management.dto.common.Relation;
import com.neu.customermanagement.management.dto.common.Role;
import com.neu.customermanagement.management.dto.customer.CusSearchCondition;
import com.neu.customermanagement.management.entity.Contact;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.entity.Handoverlog;
import com.neu.customermanagement.management.mapper.ContactMapper;
import com.neu.customermanagement.management.mapper.CustomerMapper;
import com.neu.customermanagement.management.mapper.EmployeeMapper;
import com.neu.customermanagement.management.mapper.HandoverlogMapper;
import com.neu.customermanagement.management.service.ICustomerService;
import com.neu.customermanagement.management.service.IEmployeeService;
import com.neu.customermanagement.management.service.IHandoverlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
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

    @Autowired
    HandoverlogMapper handoverlogMapper;

    @Autowired
    IHandoverlogService iHandoverlogService;


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
        CusManagePageInfo cusManagePageInfo = iCustomerService.getCusManagePageInfo("800125");
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
        System.out.println(iCustomerService.getCusManagePageInfo("800125"));
    }


    @Test
    public void test15(){
        System.out.println(customerMapper.findMaxCusId());
    }


    @Test
    public void test16(){
        Customer customer = new Customer();
        customer.setCusName("hhhhh");
        customer.setCusId("800007");
        customer.setCusTaxpayerId("1001");
        int s = 100;
        try {
            s = customerMapper.insert(customer);
        }catch (Exception exception){
            System.out.println("===================");
            System.out.println(s);
        }


    }

    @Test
    public void test17(){
        Contact contact = new Contact();
        contact.setConCustomerId("800006");
        contact.setConName("hello sir2");
        contactMapper.insert(contact);
    }


    @Test
    public void test18(){
        Customer customer = new Customer();
        customer.setCusTaxpayerId("9999");
        customer.setCusName("NBL");

        List<Contact> contactList = new ArrayList<>();
        Contact contact = new Contact();
        contact.setConName("David");
        contactList.add(contact);

        List<Relation> relationList = new ArrayList<>();
        Relation relation = new Relation();
        relation.setCusrelCusRelatedCusId("100001");
        relation.setCusrelRelation("20");
        relationList.add(relation);

        AddCustomerInfo addCustomerInfo = new AddCustomerInfo();
        addCustomerInfo.setCustomer(customer);
        addCustomerInfo.setContactList(contactList);
        addCustomerInfo.setRelationList(relationList);

        System.out.println(iCustomerService.addCustomers(addCustomerInfo));

    }


    @Test
    public void test19(){
        System.out.println(customerMapper.judgeMultiFather1("800009","800001"));
    }


    @Test
    public void test20(){
        List<String> relationList = new ArrayList<>();
        relationList.add("1");
        relationList.add("2");
        relationList.add("3");
        for (int i = 0; i < relationList.size(); i++) {
            for (int j = i+1; j < relationList.size(); j++) {
                System.out.println(relationList.get(i)+"---"+relationList.get(j));
            }
        }
    }


    @Test
    public void test21(){
        Customer customer = new Customer();
        customer.setCusId("800006");
        customer.setCusAddress("Beijing street001");
        customerMapper.updateById(customer);
    }

    @Test
    public void test22(){
        System.out.println(customerMapper.deleteRelByIds("800009","800008"));
    }


    @Test
    public void test23(){
        System.out.println(customerMapper.frozenCustomer("800001","20"));
    }

    @Test
    public void test24(){
        System.out.println(iCustomerService.getCustomerByName("CBA"));
    }

    @Test
    public void test25(){
        int k = customerMapper.judgeMultiFather1("800009", "800002");
        System.out.println(k);
    }

    @Test
    public void test26(){
        System.out.println(handoverlogMapper.getAllDept());
        System.out.println(handoverlogMapper.getAllEmp());
    }

    @Test
    public void test27(){
        Handoverlog handoverlog = new Handoverlog();
        handoverlog.sethCusId("800001");
        handoverlog.sethOppId("20210004");
        handoverlog.sethOutCusManagerId("800123");
        handoverlog.sethInCusManagerId("800124");
        handoverlogMapper.insert(handoverlog);
    }


    @Test
    public void test28(){
        CusSearchCondition cusSearchCondition = new CusSearchCondition();
        cusSearchCondition.setCusName("Neu");
        System.out.println(customerMapper.getCustomers(cusSearchCondition));
    }




}
