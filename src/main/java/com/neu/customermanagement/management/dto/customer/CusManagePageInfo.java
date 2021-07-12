package com.neu.customermanagement.management.dto.customer;

import com.neu.customermanagement.management.dto.common.DeptInfo;
import com.neu.customermanagement.management.dto.common.EmpInfo;

import java.io.Serializable;
import java.util.List;

public class CusManagePageInfo implements Serializable {
    private List<DeptInfo> deptInfoList;
    private List<EmpInfo> empInfoList;
    private List<CusSearchResult> cusSearchResultList;

    public List<DeptInfo> getDeptInfoList() {
        return deptInfoList;
    }

    public void setDeptInfoList(List<DeptInfo> deptInfoList) {
        this.deptInfoList = deptInfoList;
    }

    public List<EmpInfo> getEmpInfoList() {
        return empInfoList;
    }

    public void setEmpInfoList(List<EmpInfo> empInfoList) {
        this.empInfoList = empInfoList;
    }

    public List<CusSearchResult> getCusSearchResultList() {
        return cusSearchResultList;
    }

    public void setCusSearchResultList(List<CusSearchResult> cusSearchResultList) {
        this.cusSearchResultList = cusSearchResultList;
    }

    @Override
    public String toString() {
        return "CusManagePageInfo{" +
                "deptInfoList=" + deptInfoList +
                ", empInfoList=" + empInfoList +
                ", cusSearchResultList=" + cusSearchResultList +
                '}';
    }
}
