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
 * @since 2021-07-12
 */
public class Handoverlog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "h_id", type = IdType.AUTO)
    private Integer hId;

    private String hOutCusManagerId;

    private String hInCusManagerId;

    private String hCusId;

    private String hOppId;


    public Integer gethId() {
        return hId;
    }

    public void sethId(Integer hId) {
        this.hId = hId;
    }

    public String gethOutCusManagerId() {
        return hOutCusManagerId;
    }

    public void sethOutCusManagerId(String hOutCusManagerId) {
        this.hOutCusManagerId = hOutCusManagerId;
    }

    public String gethInCusManagerId() {
        return hInCusManagerId;
    }

    public void sethInCusManagerId(String hInCusManagerId) {
        this.hInCusManagerId = hInCusManagerId;
    }

    public String gethCusId() {
        return hCusId;
    }

    public void sethCusId(String hCusId) {
        this.hCusId = hCusId;
    }

    public String gethOppId() {
        return hOppId;
    }

    public void sethOppId(String hOppId) {
        this.hOppId = hOppId;
    }

    @Override
    public String toString() {
        return "Handoverlog{" +
        "hId=" + hId +
        ", hOutCusManagerId=" + hOutCusManagerId +
        ", hInCusManagerId=" + hInCusManagerId +
        ", hCusId=" + hCusId +
        ", hOppId=" + hOppId +
        "}";
    }
}
