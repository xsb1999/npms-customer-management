package com.neu.customermanagement.management.dto.opportunity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OpportunityBasicInfo implements Serializable {
    private String oppId;

    private String oppName;

    private LocalDateTime oppSignTime;

    private String oppBelonging;

    private String oppPhase;

    private String oppBackground;

    private String oppCusId;

    private String CusName;

    public String getOppId() {
        return oppId;
    }

    public void setOppId(String oppId) {
        this.oppId = oppId;
    }

    public String getOppName() {
        return oppName;
    }

    public void setOppName(String oppName) {
        this.oppName = oppName;
    }

    public LocalDateTime getOppSignTime() {
        return oppSignTime;
    }

    public void setOppSignTime(LocalDateTime oppSignTime) {
        this.oppSignTime = oppSignTime;
    }

    public String getOppBelonging() {
        return oppBelonging;
    }

    public void setOppBelonging(String oppBelonging) {
        this.oppBelonging = oppBelonging;
    }

    public String getOppPhase() {
        return oppPhase;
    }

    public void setOppPhase(String oppPhase) {
        this.oppPhase = oppPhase;
    }

    public String getOppBackground() {
        return oppBackground;
    }

    public void setOppBackground(String oppBackground) {
        this.oppBackground = oppBackground;
    }

    public String getOppCusId() {
        return oppCusId;
    }

    public void setOppCusId(String oppCusId) {
        this.oppCusId = oppCusId;
    }

    public String getCusName() {
        return CusName;
    }

    public void setCusName(String cusName) {
        CusName = cusName;
    }

    @Override
    public String toString() {
        return "OpportunityBasicInfo{" +
                "oppId='" + oppId + '\'' +
                ", oppName='" + oppName + '\'' +
                ", oppSignTime=" + oppSignTime +
                ", oppBelonging='" + oppBelonging + '\'' +
                ", oppPhase='" + oppPhase + '\'' +
                ", oppBackground='" + oppBackground + '\'' +
                ", oppCusId='" + oppCusId + '\'' +
                ", CusName='" + CusName + '\'' +
                '}';
    }
}
