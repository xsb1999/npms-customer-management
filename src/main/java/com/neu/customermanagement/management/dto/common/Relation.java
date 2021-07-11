package com.neu.customermanagement.management.dto.common;

import java.io.Serializable;

public class Relation implements Serializable {
    private String cusrelCusId; // 客户id
    private String cusrelCusRelatedCusId;   // 关联客户id
    private String cusrelCusName;   // 客户名称
    private String cusrelCusRelatedCusName; // 关联客户名称
    private String cusrelRelation;  // 关系(10:母公司，20:子公司，30:控股公司)

    public String getCusrelCusId() {
        return cusrelCusId;
    }

    public void setCusrelCusId(String cusrelCusId) {
        this.cusrelCusId = cusrelCusId;
    }

    public String getCusrelCusRelatedCusId() {
        return cusrelCusRelatedCusId;
    }

    public void setCusrelCusRelatedCusId(String cusrelCusRelatedCusId) {
        this.cusrelCusRelatedCusId = cusrelCusRelatedCusId;
    }

    public String getCusrelCusName() {
        return cusrelCusName;
    }

    public void setCusrelCusName(String cusrelCusName) {
        this.cusrelCusName = cusrelCusName;
    }

    public String getCusrelCusRelatedCusName() {
        return cusrelCusRelatedCusName;
    }

    public void setCusrelCusRelatedCusName(String cusrelCusRelatedCusName) {
        this.cusrelCusRelatedCusName = cusrelCusRelatedCusName;
    }

    public String getCusrelRelation() {
        return cusrelRelation;
    }

    public void setCusrelRelation(String cusrelRelation) {
        this.cusrelRelation = cusrelRelation;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "cusrelCusId='" + cusrelCusId + '\'' +
                ", cusrelCusRelatedCusId='" + cusrelCusRelatedCusId + '\'' +
                ", cusrelCusName='" + cusrelCusName + '\'' +
                ", cusrelCusRelatedCusName='" + cusrelCusRelatedCusName + '\'' +
                ", cusrelRelation='" + cusrelRelation + '\'' +
                '}';
    }
}
