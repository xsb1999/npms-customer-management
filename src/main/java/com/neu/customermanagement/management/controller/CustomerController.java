package com.neu.customermanagement.management.controller;


import com.neu.customermanagement.management.dto.CusDetail;
import com.neu.customermanagement.management.dto.CusManagePageInfo;
import com.neu.customermanagement.management.dto.DeptInfo;
import com.neu.customermanagement.management.dto.EmpInfo;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.entity.Employee;
import com.neu.customermanagement.management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xsb
 * @since 2021-07-07
 */
@RestController
@RequestMapping("/management/customer")
public class CustomerController {

    @Autowired
    ICustomerService iCustomerService;

    // 初始化客户管理页面
    @GetMapping("getMainPage")
    public CusManagePageInfo getMainPage(@RequestBody Employee employee){
        String emp_id = employee.getEmpId();
        String emp_position = employee.getEmpPositionId();
        return iCustomerService.getCusManagePageInfo(emp_id,emp_position);
    }

    // 销售部门和客户经理二级联动
    @GetMapping("getEmpByDept")
    public List<EmpInfo> getEmpByDept(@RequestBody DeptInfo dept){
        return iCustomerService.getEmpByDept(dept.getDeptId());
    }

    // 点击客户编号展示客户详细信息
    @GetMapping("getCusDetail")
    public CusDetail getCusDetail(@RequestBody Customer customer){
        String cus_id = customer.getCusId();
        return iCustomerService.getCusDetail(cus_id);
    }

}

