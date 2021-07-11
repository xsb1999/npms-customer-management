package com.neu.customermanagement.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author xsb
 * @since 2021-07-07
 */
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String conId;

    private String conCustomerId;

    private String conName;

    private String conDept;

    private String conRole;

    private String conLandlinePhone;

    private String conMobilePhone;

    private String conFax;

    private String conEmail;

    private String conQq;

    private String conWechat;


    public String getConId() {
        return conId;
    }

    public void setConId(String conId) {
        this.conId = conId;
    }

    public String getConCustomerId() {
        return conCustomerId;
    }

    public void setConCustomerId(String conCustomerId) {
        this.conCustomerId = conCustomerId;
    }

    public String getConName() {
        return conName;
    }

    public void setConName(String conName) {
        this.conName = conName;
    }

    public String getConDept() {
        return conDept;
    }

    public void setConDept(String conDept) {
        this.conDept = conDept;
    }

    public String getConRole() {
        return conRole;
    }

    public void setConRole(String conRole) {
        this.conRole = conRole;
    }

    public String getConLandlinePhone() {
        return conLandlinePhone;
    }

    public void setConLandlinePhone(String conLandlinePhone) {
        this.conLandlinePhone = conLandlinePhone;
    }

    public String getConMobilePhone() {
        return conMobilePhone;
    }

    public void setConMobilePhone(String conMobilePhone) {
        this.conMobilePhone = conMobilePhone;
    }

    public String getConFax() {
        return conFax;
    }

    public void setConFax(String conFax) {
        this.conFax = conFax;
    }

    public String getConEmail() {
        return conEmail;
    }

    public void setConEmail(String conEmail) {
        this.conEmail = conEmail;
    }

    public String getConQq() {
        return conQq;
    }

    public void setConQq(String conQq) {
        this.conQq = conQq;
    }

    public String getConWechat() {
        return conWechat;
    }

    public void setConWechat(String conWechat) {
        this.conWechat = conWechat;
    }

    @Override
    public String toString() {
        return "Contact{" +
        "conId=" + conId +
        ", conCustomerId=" + conCustomerId +
        ", conName=" + conName +
        ", conDept=" + conDept +
        ", conRole=" + conRole +
        ", conLandlinePhone=" + conLandlinePhone +
        ", conMobilePhone=" + conMobilePhone +
        ", conFax=" + conFax +
        ", conEmail=" + conEmail +
        ", conQq=" + conQq +
        ", conWechat=" + conWechat +
        "}";
    }
}
