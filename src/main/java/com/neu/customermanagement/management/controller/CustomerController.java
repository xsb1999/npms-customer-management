package com.neu.customermanagement.management.controller;


import com.neu.customermanagement.management.dto.CusManagePageInfo;
import com.neu.customermanagement.management.entity.Employee;
import com.neu.customermanagement.management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("getMainPage")
    public CusManagePageInfo getMainPage(@RequestBody Employee employee){
        String emp_id = employee.getEmpId();
        String emp_position = employee.getEmpPositionId();
        return iCustomerService.getCusManagePageInfo(emp_id,emp_position);
    }

}

