package com.neu.customermanagement.management.controller;


import com.neu.customermanagement.management.dto.handover.HandoverInfo;
import com.neu.customermanagement.management.dto.handover.HandoverInfoSearch;
import com.neu.customermanagement.management.dto.handover.HandoverPageInfo;
import com.neu.customermanagement.management.dto.opportunity.OppDetail;
import com.neu.customermanagement.management.entity.Customer;
import com.neu.customermanagement.management.entity.Opportunity;
import com.neu.customermanagement.management.service.IHandoverlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xsb
 * @since 2021-07-12
 */
@RestController
@RequestMapping("/management/handoverlog")
public class HandoverlogController {

    @Autowired
    IHandoverlogService iHandoverlogService;

    // 初始化客户移交页面
    @GetMapping("getHandoverPage")
    public HandoverPageInfo getHandoverPage(){
        return iHandoverlogService.getHandoverPage();
    }

    // 查询移出方的客户信息
    @GetMapping("searchOutCusInfo")
    public List<Customer> searchOutCusInfo(@RequestBody HandoverInfoSearch handoverInfoSearch){
        return iHandoverlogService.searchOutCusInfo(handoverInfoSearch);
    }

    // 点击机会id显示机会详细信息
    @GetMapping("showOppDetail")
    public OppDetail showOppDetail(@RequestBody Opportunity opportunity){
        String opp_id = opportunity.getOppId();
        return iHandoverlogService.showOppDetail(opp_id);
    }

    // 选择客户，展示对应的机会列表
    @GetMapping("getOppByCusId")
    public List<Opportunity> getOppByCusId(@RequestBody Customer customer){
        String cus_id = customer.getCusId();
        return iHandoverlogService.getOppByCusId(cus_id);
    }

    // 客户移交
    @PostMapping("handover")
    public List<Customer> handover(@RequestBody HandoverInfo handoverInfo){
        return iHandoverlogService.handover(handoverInfo);
    }


}

