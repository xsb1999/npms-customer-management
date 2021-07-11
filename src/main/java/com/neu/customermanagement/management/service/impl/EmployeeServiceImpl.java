package com.neu.customermanagement.management.service.impl;

import com.neu.customermanagement.management.dto.common.Role;
import com.neu.customermanagement.management.entity.Employee;
import com.neu.customermanagement.management.mapper.EmployeeMapper;
import com.neu.customermanagement.management.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xsb
 * @since 2021-07-08
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    @Override
    public List<Role> getRoleById(String id) {
        return employeeMapper.getRoleById(id);
    }

    @Override
    public String getEmpNameById(String emp_id) {
        return employeeMapper.getEmpNameById(emp_id);
    }
}
