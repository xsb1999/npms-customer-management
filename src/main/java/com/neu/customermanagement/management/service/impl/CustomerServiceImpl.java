package com.neu.customermanagement.management.service.impl;

import com.neu.customermanagement.management.dto.CusManagePageInfo;
import com.neu.customermanagement.management.dto.CusSearchResult;
import com.neu.customermanagement.management.dto.DeptInfo;
import com.neu.customermanagement.management.dto.EmpInfo;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.mapper.CustomerMapper;
import com.neu.customermanagement.management.mapper.EmployeeMapper;
import com.neu.customermanagement.management.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xsb
 * @since 2021-07-07
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements ICustomerService {

    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    EmployeeMapper employeeMapper;


    @Override
    public CusManagePageInfo getCusManagePageInfo(String emp_id, String emp_position) {
        List<DeptInfo> deptInfoList = new ArrayList<>();
        List<EmpInfo> empInfoList = new ArrayList<>();
        List<CusSearchResult> cusSearchResultList = new ArrayList<>();

        // 事业部总经理（展示该部门下客户经理的客户列表）
        if (emp_position.equals("10000030")){
            // 获取当前登录人所在部门
            deptInfoList = customerMapper.getDeptInfoByEmpId(emp_id);
            // 获取该部门下的所有的客户经理
            empInfoList = customerMapper.getEmpInfoByEmpIdAndDeptId(null,deptInfoList.get(0).getDeptId());
            // 获取当前登录人的客户列表（事业部总经理，返回该部门下的全部客户）
            cusSearchResultList = customerMapper.getCusSearchResult(null, deptInfoList.get(0).getDeptId());
            for (CusSearchResult cr : cusSearchResultList) {
                // 设定部门名称
                cr.setCusSalesDeptName(deptInfoList.get(0).getDeptName());
                // 根据客户经理id获取客户经理姓名
                cr.setCusCustomerManagerName(employeeMapper.getEmpNameById(cr.getCusCustomerManagerId()));
            }
        }
        // 销售总监（展示该部门下客户经理的客户列表）
        if (emp_position.equals("30000010")){
            // 获取当前登录人所在部门
            deptInfoList = customerMapper.getDeptInfoByEmpId(emp_id);
            // 获取该部门下的所有的客户经理
            empInfoList = customerMapper.getEmpInfoByEmpIdAndDeptId(null,deptInfoList.get(0).getDeptId());
            // 获取当前登录人的客户列表（销售总监，返回自己的全部客户）
            cusSearchResultList = customerMapper.getCusSearchResult(emp_id, null);
            for (CusSearchResult cr : cusSearchResultList) {
                // 设定部门名称
                cr.setCusSalesDeptName(deptInfoList.get(0).getDeptName());
                // 根据客户经理id获取客户经理姓名
                cr.setCusCustomerManagerName(employeeMapper.getEmpNameById(cr.getCusCustomerManagerId()));
            }
        }
        // 客户经理（展示本人的客户列表）
        if (emp_position.equals("30000030")){
            // 获取当前登录人所在部门
            deptInfoList = customerMapper.getDeptInfoByEmpId(emp_id);
            // 获取该客户经理的信息
            empInfoList = customerMapper.getEmpInfoByEmpIdAndDeptId(emp_id, null);
            // 获取当前登录人的客户列表（客户经理，返回自己的全部客户）
            cusSearchResultList = customerMapper.getCusSearchResult(emp_id, null);
            for (CusSearchResult cr : cusSearchResultList) {
                // 设定部门名称
                cr.setCusSalesDeptName(deptInfoList.get(0).getDeptName());
                // 设定客户经理姓名
                cr.setCusCustomerManagerName(empInfoList.get(0).getEmpName());
            }
        }

        // 营销专员、营销副总和高层领导（可以看到所有部门和客户经理）
        if (emp_position.equals("20000010") || emp_position.equals("20000020") || emp_position.equals("50000000")){
            // 获取所有部门
            deptInfoList = customerMapper.getDeptInfoByEmpId(null);
            // 获取所有的客户经理
            empInfoList = customerMapper.getEmpInfoByEmpIdAndDeptId(null,null);
            // 获取当前登录人的客户列表（默认显示为空）
            cusSearchResultList = new ArrayList<>();
        }

        CusManagePageInfo cusManagePageInfo = new CusManagePageInfo();
        cusManagePageInfo.setDeptInfoList(deptInfoList);
        cusManagePageInfo.setEmpInfoList(empInfoList);
        cusManagePageInfo.setCusSearchResultList(cusSearchResultList);

        return cusManagePageInfo;
    }
}
