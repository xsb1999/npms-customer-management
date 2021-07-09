package com.neu.customermanagement.management.service;

import com.neu.customermanagement.management.dto.CusDetail;
import com.neu.customermanagement.management.dto.CusManagePageInfo;
import com.neu.customermanagement.management.dto.EmpInfo;
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

}
