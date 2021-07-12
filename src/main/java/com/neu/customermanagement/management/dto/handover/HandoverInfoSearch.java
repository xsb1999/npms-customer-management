package com.neu.customermanagement.management.dto.handover;

import java.io.Serializable;

public class HandoverInfoSearch implements Serializable {
    private String cusSalesDeptId;
    private String cusCustomerManagerId;
    private String cusName;

    public String getCusSalesDeptId() {
        return cusSalesDeptId;
    }

    public void setCusSalesDeptId(String cusSalesDeptId) {
        this.cusSalesDeptId = cusSalesDeptId;
    }

    public String getCusCustomerManagerId() {
        return cusCustomerManagerId;
    }

    public void setCusCustomerManagerId(String cusCustomerManagerId) {
        this.cusCustomerManagerId = cusCustomerManagerId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    @Override
    public String toString() {
        return "OutHandoverInfoSearch{" +
                "cusSalesDeptId='" + cusSalesDeptId + '\'' +
                ", cusCustomerManagerId='" + cusCustomerManagerId + '\'' +
                ", cusName='" + cusName + '\'' +
                '}';
    }
}
