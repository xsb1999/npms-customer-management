package com.neu.customermanagement.management.dto.customer;

import java.io.Serializable;

public class CusSearchResult implements Serializable {
    private String cusId;
    private String cusName;
    private String cusProductType;
    private String cusEnterpriseProperty;
    private String cusSalesDeptId;
    private String cusCustomerManagerId;
    private String cusSalesDeptName;
    private String cusCustomerManagerName;

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getCusProductType() {
        return cusProductType;
    }

    public void setCusProductType(String cusProductType) {
        this.cusProductType = cusProductType;
    }

    public String getCusEnterpriseProperty() {
        return cusEnterpriseProperty;
    }

    public void setCusEnterpriseProperty(String cusEnterpriseProperty) {
        this.cusEnterpriseProperty = cusEnterpriseProperty;
    }

    public String getCusSalesDeptName() {
        return cusSalesDeptName;
    }

    public void setCusSalesDeptName(String cusSalesDeptName) {
        this.cusSalesDeptName = cusSalesDeptName;
    }

    public String getCusCustomerManagerName() {
        return cusCustomerManagerName;
    }

    public void setCusCustomerManagerName(String cusCustomerManagerName) {
        this.cusCustomerManagerName = cusCustomerManagerName;
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
        return "CusSearchResult{" +
                "cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", cusProductType='" + cusProductType + '\'' +
                ", cusEnterpriseProperty='" + cusEnterpriseProperty + '\'' +
                ", cusSalesDeptId='" + cusSalesDeptId + '\'' +
                ", cusCustomerManagerId='" + cusCustomerManagerId + '\'' +
                ", cusSalesDeptName='" + cusSalesDeptName + '\'' +
                ", cusCustomerManagerName='" + cusCustomerManagerName + '\'' +
                '}';
    }
}
