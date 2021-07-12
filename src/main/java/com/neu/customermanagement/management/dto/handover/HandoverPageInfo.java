package com.neu.customermanagement.management.dto.handover;

import com.neu.customermanagement.management.dto.common.DeptInfo;
import com.neu.customermanagement.management.dto.common.EmpInfo;

import java.io.Serializable;
import java.util.List;

public class HandoverPageInfo implements Serializable {
    private List<DeptInfo> deptInfoList;
    private List<EmpInfo> empInfoList;

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

    @Override
    public String toString() {
        return "HandoverPageInfo{" +
                "deptInfoList=" + deptInfoList +
                ", empInfoList=" + empInfoList +
                '}';
    }
}
