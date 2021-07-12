package com.neu.customermanagement.management.dto.handover;

import com.neu.customermanagement.management.entity.Customer;

import java.io.Serializable;
import java.util.List;

public class HandoverInfo implements Serializable {
    private String outDeptId; // 移出方销售部门id
    private String outCusMgrId;  // 移出方客户经理id
    private String inDeptId;  // 接收方销售部门id
    private String inCusMgrId;  // 接收方客户经理id
    private List<Customer> customerList;    // 选择移交的客户list

    public String getOutDeptId() {
        return outDeptId;
    }

    public void setOutDeptId(String outDeptId) {
        this.outDeptId = outDeptId;
    }

    public String getOutCusMgrId() {
        return outCusMgrId;
    }

    public void setOutCusMgrId(String outCusMgrId) {
        this.outCusMgrId = outCusMgrId;
    }

    public String getInDeptId() {
        return inDeptId;
    }

    public void setInDeptId(String inDeptId) {
        this.inDeptId = inDeptId;
    }

    public String getInCusMgrId() {
        return inCusMgrId;
    }

    public void setInCusMgrId(String inCusMgrId) {
        this.inCusMgrId = inCusMgrId;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public String toString() {
        return "HandoverInfo{" +
                "outDeptId='" + outDeptId + '\'' +
                ", outCusMgrId='" + outCusMgrId + '\'' +
                ", inDeptId='" + inDeptId + '\'' +
                ", inCusMgrId='" + inCusMgrId + '\'' +
                ", customerList=" + customerList +
                '}';
    }
}
