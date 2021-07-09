package com.neu.customermanagement.management.mapper;

import com.neu.customermanagement.management.dto.*;
import com.neu.customermanagement.management.entity.Customer;
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
 * @since 2021-07-07
 */
@Mapper
@Repository
public interface CustomerMapper extends BaseMapper<Customer> {

    // 获取当前登录人所在部门（根据员工id）
    public List<DeptInfo> getDeptInfoByEmpId(String emp_id);

    // 获取当前登录人的信息（根据员工id和部门id）
    public List<EmpInfo> getEmpInfoByEmpIdAndDeptId(String emp_id, String dept_id);

    // 获取当前登录人的客户列表（如果是销售经理则返回该部门下的全部客户，若是总经理，则返回全部客户）
    public List<CusSearchResult> getCusSearchResult(String emp_id, String dept_id);

    // 销售部门和客户经理二级联动
    public List<EmpInfo> getEmpByDept(String dept_id);

    // 根据客户id查询客户的关联客户信息
    public List<Relation> getRelationByCusId(String cus_id);

    // 根据客户id查询客户名称
    public String getCusNameByCusId(String cus_id);

}
