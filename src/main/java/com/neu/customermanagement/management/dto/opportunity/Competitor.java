package com.neu.customermanagement.management.dto.opportunity;

import java.io.Serializable;

public class Competitor implements Serializable {
    private String compName;
    private String compPosition;

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompPosition() {
        return compPosition;
    }

    public void setCompPosition(String compPosition) {
        this.compPosition = compPosition;
    }

    @Override
    public String toString() {
        return "Competitor{" +
                "compName='" + compName + '\'' +
                ", compPosition='" + compPosition + '\'' +
                '}';
    }
}
