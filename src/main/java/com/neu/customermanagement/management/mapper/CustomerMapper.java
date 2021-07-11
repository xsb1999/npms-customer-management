package com.neu.customermanagement.management.mapper;

import com.neu.customermanagement.management.dto.*;
import com.neu.customermanagement.management.dto.common.DeptInfo;
import com.neu.customermanagement.management.dto.common.EmpInfo;
import com.neu.customermanagement.management.dto.common.Relation;
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

    // 客户查询
    public List<CusSearchResult> getCustomers(CusSearchCondition searchCondition);

    // 在数据库中查询得到目前最大的客户id
    public String findMaxCusId();

    // insert到关联客户表
    public int addCusRelated(Relation relation);

    // 判断纳税人识别号是否唯一
    public int judgeTaxId(String tax_id);

    // 判断关联客户是否只录入了当前客户的父节点，不可关联多级父节点(针对于查询新增或修改的一对关系中，当前客户和关联客户的引入是否会关联多级父节点)
    public int judgeMultiFather1(String cus_id_son, String cus_id_father);

    // 判断关联客户是否只录入了当前客户的父节点，不可关联多级父节点(针对于查询新增或修改的一对关系中，关联客户之间的引入是否会关联多级父节点)
    public int judgeMultiFather2(String cus_id1, String cus_id2);

    // 删除关联客户
    public int deleteRelByIds(String id1, String id2);

    // 删除客户联系人（通过客户id和客户联系人姓名）
    public int deleteConByNameAndId(String cus_id, String con_name);

}
