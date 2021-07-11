package com.neu.customermanagement.management.mapper;

import com.neu.customermanagement.management.dto.common.Role;
import com.neu.customermanagement.management.entity.Employee;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xsb
 * @since 2021-07-08
 */
@Mapper
@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {
    // 获取员工得roles
    public List<Role> getRoleById(String emp_id);
    // 通过员工id获取姓名
    public String getEmpNameById(String emp_id);
    // 通过部门id获取部门名称
    public String getDeptNameById(String dept_id);
}
