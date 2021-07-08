package com.neu.customermanagement.management.service;

import com.neu.customermanagement.management.dto.Role;
import com.neu.customermanagement.management.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xsb
 * @since 2021-07-08
 */
public interface IEmployeeService extends IService<Employee> {
    // 获取员工的roles
    public List<Role> getRoleById(String emp_id);
    // 通过员工id获取姓名
    public String getEmpNameById(String emp_id);

}
