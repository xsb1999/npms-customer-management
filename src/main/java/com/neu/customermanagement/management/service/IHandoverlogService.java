package com.neu.customermanagement.management.service;

import com.neu.customermanagement.management.dto.handover.HandoverInfo;
import com.neu.customermanagement.management.dto.handover.HandoverInfoSearch;
import com.neu.customermanagement.management.dto.handover.HandoverPageInfo;
import com.neu.customermanagement.management.dto.opportunity.OppDetail;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.entity.Handoverlog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neu.customermanagement.management.entity.Opportunity;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xsb
 * @since 2021-07-12
 */
public interface IHandoverlogService extends IService<Handoverlog> {
    // 初始化客户移交页面
    public HandoverPageInfo getHandoverPage();
    // 查询移出方的客户信息
    public List<Customer> searchOutCusInfo(HandoverInfoSearch handoverInfoSearch);
    // 点击机会id显示客户详细信息
    public OppDetail showOppDetail(String opp_id);
    // 选择客户，展示对应的机会列表
    public List<Opportunity> getOppByCusId(String cus_id);
    // 客户移交
    public List<Customer> handover(HandoverInfo handoverInfo);
}
