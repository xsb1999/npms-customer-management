package com.neu.customermanagement.management.dto.customer;

import java.io.Serializable;

public class CusSearchCondition implements Serializable {
    private String cusName;
    private String cusId;
    private String cusEnterpriseProperty;
    private String cusSalesDeptId;
    private String cusCustomerManagerId;

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusEnterpriseProperty() {
        return cusEnterpriseProperty;
    }

    public void setCusEnterpriseProperty(String cusEnterpriseProperty) {
        this.cusEnterpriseProperty = cusEnterpriseProperty;
    }

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

    @Override
    public String toString() {
        return "CusSearchCondition{" +
                "cusName='" + cusName + '\'' +
                ", cusId='" + cusId + '\'' +
                ", cusEnterpriseProperty='" + cusEnterpriseProperty + '\'' +
                ", cusSalesDeptId='" + cusSalesDeptId + '\'' +
                ", cusCustomerManagerId='" + cusCustomerManagerId + '\'' +
                '}';
    }
}
