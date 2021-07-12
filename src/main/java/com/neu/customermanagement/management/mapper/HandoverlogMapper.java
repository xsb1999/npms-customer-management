package com.neu.customermanagement.management.mapper;

import com.neu.customermanagement.management.dto.common.DeptInfo;
import com.neu.customermanagement.management.dto.common.EmpInfo;
import com.neu.customermanagement.management.dto.handover.HandoverInfoSearch;
import com.neu.customermanagement.management.dto.opportunity.Competitor;
import com.neu.customermanagement.management.dto.opportunity.OpportunityBasicInfo;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.entity.Handoverlog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.neu.customermanagement.management.entity.Opportunity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xsb
 * @since 2021-07-12
 */
@Mapper
@Repository
public interface HandoverlogMapper extends BaseMapper<Handoverlog> {

    // 获取所有部门列表
    public List<DeptInfo> getAllDept();
    // 获取所有客户经理列表
    public List<EmpInfo> getAllEmp();
    // 查询移出方的客户信息
    public List<Customer> searchOutCusInfo (HandoverInfoSearch handoverInfoSearch);
    // 根据机会id查询竞争对手列表
    public List<Competitor> getCompetitorsByOppId(String opp_id);
    // 根据机会id查询机会
    public OpportunityBasicInfo getOppById(String opp_id);

}
