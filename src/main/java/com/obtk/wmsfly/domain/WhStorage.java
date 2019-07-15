package com.obtk.wmsfly.domain;

import java.math.BigDecimal;

public class WhStorage {
    private String itemcode;

    private String wareCode;

    private String oldcode;

    private String breadcode;

    private String standard;

    private Integer item_Piece;

    private BigDecimal plannum;

    private BigDecimal itemnum;

    private String facCode;

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode == null ? null : wareCode.trim();
    }

    public String getOldcode() {
        return oldcode;
    }

    public void setOldcode(String oldcode) {
        this.oldcode = oldcode == null ? null : oldcode.trim();
    }

    public String getBreadcode() {
        return breadcode;
    }

    public void setBreadcode(String breadcode) {
        this.breadcode = breadcode == null ? null : breadcode.trim();
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard == null ? null : standard.trim();
    }

    public Integer getItem_Piece() {
        return item_Piece;
    }

    public void setItem_Piece(Integer item_Piece) {
        this.item_Piece = item_Piece;
    }

    public BigDecimal getPlannum() {
        return plannum;
    }

    public void setPlannum(BigDecimal plannum) {
        this.plannum = plannum;
    }

    public BigDecimal getItemnum() {
        return itemnum;
    }

    public void setItemnum(BigDecimal itemnum) {
        this.itemnum = itemnum;
    }

    public String getFacCode() {
        return facCode;
    }

    public void setFacCode(String facCode) {
        this.facCode = facCode == null ? null : facCode.trim();
    }
}