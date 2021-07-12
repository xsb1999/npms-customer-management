package com.neu.customermanagement.management.service;

import com.neu.customermanagement.management.dto.common.EmpInfo;
import com.neu.customermanagement.management.dto.customer.*;
import com.neu.customermanagement.management.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xsb
 * @since 2021-07-07
 */
public interface ICustomerService extends IService<Customer> {

    // 初始化客户管理页面
    public CusManagePageInfo getCusManagePageInfo(String emp_id, String emp_position);

    // 销售部门和客户经理二级联动
    public List<EmpInfo> getEmpByDept(String dept_id);

    // 点击客户编号展示客户详细信息
    public CusDetail getCusDetail(String cus_id);

    // 客户查询
    public List<CusSearchResult> getCustomers(CusSearchCondition searchCondition);

    // 客户新增
    public String addCustomers(AddCustomerInfo addCustomerInfo);

    // 客户修改
    public String updateCustomers(UpdateCustomerInfo updateCustomerInfo);

    // 冻结客户（点击"冻结"按钮）
    public int frozenCustomer(String cus_id, String cus_status);

    // 关联客户列表中通过客户名称查询客户id
    public List<Customer> getCustomerByName (String cus_name);


}
