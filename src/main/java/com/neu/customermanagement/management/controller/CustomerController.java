package com.neu.customermanagement.management.controller;


import com.neu.customermanagement.management.dto.common.DeptInfo;
import com.neu.customermanagement.management.dto.common.EmpInfo;
import com.neu.customermanagement.management.dto.customer.*;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.entity.Employee;
import com.neu.customermanagement.management.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/cusManagement/customer")
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

    // 客户查询
    @GetMapping("getCustomers")
    public List<CusSearchResult> getCustomers(@RequestBody CusSearchCondition condition){
        return iCustomerService.getCustomers(condition);
    }

    // 客户新增
    @PostMapping("addCustomers")
    public String addCustomers(@RequestBody AddCustomerInfo addCustomerInfo){
        String msg="";
        try {
            msg = iCustomerService.addCustomers(addCustomerInfo);
        }
        catch (Exception exception){
            msg = "系统错误，请联系管理员...";
            System.err.println(exception);
        }
        return msg;
    }


    // 客户修改
    @PostMapping("updateCustomers")
    public String updateCustomers(@RequestBody UpdateCustomerInfo updateCustomerInfo){
        String msg="";
        try {
            msg = iCustomerService.updateCustomers(updateCustomerInfo);
        }
        catch (Exception exception){
            msg = "系统错误，请联系管理员...";
            System.err.println(exception);
        }
        return msg;
    }


    // 冻结客户（点击"冻结"按钮）
    @PostMapping("frozenCustomer")
    public int frozenCustomer(@RequestBody Customer customer){
        String cus_id = customer.getCusId();
        String cus_status = customer.getCusStatus();
        return iCustomerService.frozenCustomer(cus_id, cus_status);
    }


    // 关联客户列表中通过客户名称查询客户id
    @GetMapping("getCustomerByName")
    public List<Customer> getCustomerByName(String cus_name){
        return iCustomerService.getCustomerByName(cus_name);
    }


    // 导出
    @GetMapping("export")
    public String export(){
        return "导出成功！";
    }


}

