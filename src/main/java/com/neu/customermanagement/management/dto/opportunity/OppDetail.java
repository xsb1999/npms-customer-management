package com.neu.customermanagement.management.dto.opportunity;

import com.neu.customermanagement.management.entity.Opportunity;
import com.neu.customermanagement.management.entity.Payer;
import com.neu.customermanagement.management.entity.SubOpportunity;

import java.io.Serializable;
import java.util.List;

public class OppDetail implements Serializable {
    private OpportunityBasicInfo opportunityBasicInfo;
    private List<SubOpportunity> subOpportunityList;
    private List<Competitor> competitorList;
    private List<Payer> payerList;


    public List<SubOpportunity> getSubOpportunityList() {
        return subOpportunityList;
    }

    public void setSubOpportunityList(List<SubOpportunity> subOpportunityList) {
        this.subOpportunityList = subOpportunityList;
    }

    public List<Competitor> getCompetitorList() {
        return competitorList;
    }

    public void setCompetitorList(List<Competitor> competitorList) {
        this.competitorList = competitorList;
    }

    public List<Payer> getPayerList() {
        return payerList;
    }

    public void setPayerList(List<Payer> payerList) {
        this.payerList = payerList;
    }

    public OpportunityBasicInfo getOpportunityBasicInfo() {
        return opportunityBasicInfo;
    }

    public void setOpportunityBasicInfo(OpportunityBasicInfo opportunityBasicInfo) {
        this.opportunityBasicInfo = opportunityBasicInfo;
    }

    @Override
    public String toString() {
        return "OppDetail{" +
                "opportunityBasicInfo=" + opportunityBasicInfo +
                ", subOpportunityList=" + subOpportunityList +
                ", competitorList=" + competitorList +
                ", payerList=" + payerList +
                '}';
    }
}
