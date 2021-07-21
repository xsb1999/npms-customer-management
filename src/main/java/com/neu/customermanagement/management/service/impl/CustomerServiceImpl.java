package com.neu.customermanagement.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.neu.customermanagement.management.dto.common.DeptInfo;
import com.neu.customermanagement.management.dto.common.EmpInfo;
import com.neu.customermanagement.management.dto.common.Relation;
import com.neu.customermanagement.management.dto.customer.*;
import com.neu.customermanagement.management.entity.Contact;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.entity.Employee;
import com.neu.customermanagement.management.mapper.ContactMapper;
import com.neu.customermanagement.management.mapper.CustomerMapper;
import com.neu.customermanagement.management.mapper.EmployeeMapper;
import com.neu.customermanagement.management.service.ICustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    ContactMapper contactMapper;


    @Override
    public CusManagePageInfo getCusManagePageInfo(String emp_id) {
        // 根据员工id获取员工职位
        Employee employee = employeeMapper.selectById(emp_id);
        String emp_position = employee.getEmpPositionId();

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


    @Cacheable(cacheNames="cus_getEmpByDept")
    @Override
    public List<EmpInfo> getEmpByDept(String dept_id) {

        return customerMapper.getEmpByDept(dept_id);
    }


    @Override
    public CusDetail getCusDetail(String cus_id) {

        Customer customer = null;
        List<Contact> contactList = new ArrayList<>();
        List<Relation> relationList = new ArrayList<>();
        String cus_name = customerMapper.getCusNameByCusId(cus_id);

        // 获取客户基本信息
        customer = customerMapper.selectById(cus_id);

        // 获取客户联系人信息
        QueryWrapper<Contact> qw = Wrappers.query();
        qw.eq("con_customer_id", cus_id);
        contactList = contactMapper.selectList(qw);

        // 获取客户关联客户信息
        relationList = customerMapper.getRelationByCusId(cus_id);
        for (Relation relation : relationList) {
            relation.setCusrelCusName(cus_name);
            relation.setCusrelCusRelatedCusName(customerMapper.getCusNameByCusId(relation.getCusrelCusRelatedCusId()));
        }

        CusDetail cusDetail = new CusDetail();
        cusDetail.setCustomer(customer);
        cusDetail.setContactList(contactList);
        cusDetail.setRelationList(relationList);

        return cusDetail;
    }


    @Override
    public List<CusSearchResult> getCustomers(CusSearchCondition searchCondition) {
        List<CusSearchResult> cusSearchResults = customerMapper.getCustomers(searchCondition);
        for (CusSearchResult csr : cusSearchResults) {
            // 通过员工id获取姓名
            csr.setCusSalesDeptName(employeeMapper.getDeptNameById(csr.getCusSalesDeptId()));
            // 通过部门id获取部门名称
            csr.setCusCustomerManagerName(employeeMapper.getEmpNameById(csr.getCusCustomerManagerId()));
        }
        return cusSearchResults;
    }


    @Override
    @Transactional(rollbackFor=Exception.class)
    public String addCustomers(AddCustomerInfo addCustomerInfo) {
        Customer customer = addCustomerInfo.getCustomer();
        List<Contact> contactList = addCustomerInfo.getContactList();
        List<Relation> relationList = addCustomerInfo.getRelationList();
        String msg = "客户新增成功！";
        // 判断纳税人识别号是否唯一
        if (customer.getCusTaxpayerId()!=null && customerMapper.judgeTaxId(customer.getCusTaxpayerId()) > 0){
            return "纳税人识别号重复！";
        }

        // 生成一个6位的客户id，首位为1
        // 去数据库中查询得到目前最大的id并加1，得到这个新客户的id（类似于实现了一个varchar的自增）
        String cus_id_max = customerMapper.findMaxCusId();
        String cus_id = Integer.parseInt(cus_id_max)+1+"";

        customer.setCusId(cus_id);
        for (Contact contact : contactList) {
            contact.setConCustomerId(cus_id);
        }
        for (Relation relation : relationList) {
            relation.setCusrelCusId(cus_id);
        }

        // 判断关联客户是否只录入了当前客户的父节点，不可关联多级父节点
        for (int i = 0; i < relationList.size(); i++) {
            for (int j = i+1; j < relationList.size(); j++) {
                int k = customerMapper.judgeMultiFather2(relationList.get(i).getCusrelCusRelatedCusId(),relationList.get(j).getCusrelCusRelatedCusId());
                if (k > 0) {
                    // 关联客户关联了多级父节点，不进行insert操作
                    return "不允许关联多级父节点！";
                }
            }
        }

        // 各项信息填写正确，进行insert操作
        try {
            // insert到客户表
            customerMapper.insert(customer);
            // insert到客户联系人表
            for (Contact c : contactList) {
                contactMapper.insert(c);
            }
            // insert到关联客户表
            for (Relation r : relationList) {
                customerMapper.addCusRelated(r);
            }
        }catch (Exception e){
            System.out.println("insert fail!");
            throw e;
        }
        System.out.println("insert success!");
        return msg;
    }


    @Override
    @Transactional(rollbackFor=Exception.class)
    public String updateCustomers(UpdateCustomerInfo updateCustomerInfo) {
        Customer customer = updateCustomerInfo.getCustomer();
        List<Contact> addContactsList = updateCustomerInfo.getAddContactsList();
        List<Contact> updateContactsList = updateCustomerInfo.getUpdateContactsList();
        List<String> deleteContactsName = updateCustomerInfo.getDeleteContactsName();
        List<Relation> addRelationList = updateCustomerInfo.getAddRelationList();
        List<String> deleteRelationCusId = updateCustomerInfo.getDeleteRelationCusId();
        String msg = "客户修改成功！";
        // 冻结状态不能修改和删除客户联系人信息
        if (!customer.getCusStatus().equals("10")){
            return "冻结状态不能修改和删除客户联系人信息!";
        }

        // 删除关联客户
        for (String s : deleteRelationCusId) {
            customerMapper.deleteRelByIds(customer.getCusId(), s);
        }

        for (Relation relation : addRelationList) {
            relation.setCusrelCusId(customer.getCusId());
        }

        // 判断关联客户是否只录入了当前客户的父节点，不可关联多级父节点
        for (int i = 0; i < addRelationList.size(); i++) {
            for (int j = i+1; j < addRelationList.size(); j++) {
                int k = customerMapper.judgeMultiFather2(addRelationList.get(i).getCusrelCusRelatedCusId(),addRelationList.get(j).getCusrelCusRelatedCusId());
                if (k > 0) {
                    // 关联客户关联了多级父节点，不进行insert操作
                    return "不允许关联多级父节点！";
                }
            }
        }
        for (Relation rel : addRelationList) {
            int k = customerMapper.judgeMultiFather1(rel.getCusrelCusId(), rel.getCusrelCusRelatedCusId());
            System.out.println("k= "+k);
            if (k > 0) {
                // 关联客户关联了多级父节点，不进行insert操作
                return "不允许关联多级父节点！";
            }
        }

        try{
            // update 客户基本信息
            customerMapper.updateById(customer);
            // 新增客户联系人
            for (Contact contact : addContactsList) {
                contact.setConCustomerId(customer.getCusId());
                contactMapper.insert(contact);
            }
            // delete 客户联系人
            for (String s : deleteContactsName) {
                customerMapper.deleteConByNameAndId(customer.getCusId(), s);
            }
            // update 客户联系人(by 客户id 和 name)
            for (Contact contact : updateContactsList) {
                contact.setConCustomerId(customer.getCusId());
                contactMapper.updateContacts(contact);
            }
            // 新增关联客户
            for (Relation relation : addRelationList) {
                customerMapper.addCusRelated(relation);
            }

        }catch (Exception e){
            System.out.println("update fail!");
            throw e;
        }

        System.out.println("update success!");
        return msg;
    }


    @Override
    public int frozenCustomer(String cus_id, String cus_status) {
        return customerMapper.frozenCustomer(cus_id, cus_status);
    }

    @Override
    public List<Customer> getCustomerByName(String cus_name) {
        QueryWrapper<Customer> qw = Wrappers.query();
        qw.eq("cus_name",cus_name);
        return customerMapper.selectList(qw);
    }


}
