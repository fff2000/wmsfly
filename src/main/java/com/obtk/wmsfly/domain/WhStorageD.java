package com.obtk.wmsfly.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;

public class WhStorageD {
    private String storebill;

    private String itemcode;

    private String breadcode;

    private String warecode;

    private String unitcode;

    private BigDecimal plannum;

    private BigDecimal itemnum;

    private String fromTable;

    private String indate;

    private WhOutbillD whOutbillD;

    public WhOutbillD getWhOutbillD() {
        return whOutbillD;
    }

    public void setWhOutbillD(WhOutbillD whOutbillD) {
        this.whOutbillD = whOutbillD;
    }

    public String getStorebill() {
        return storebill;
    }

    public void setStorebill(String storebill) {
        this.storebill = storebill;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getBreadcode() {
        return breadcode;
    }

    public void setBreadcode(String breadcode) {
        this.breadcode = breadcode;
    }

    public String getWarecode() {
        return warecode;
    }

    public void setWarecode(String warecode) {
        this.warecode = warecode;
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode;
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

    public String getFromTable() {
        return fromTable;
    }

    public void setFromTable(String fromTable) {
        this.fromTable = fromTable;
    }

    public String getIndate() {
        return indate;
    }

    public void setIndate(String indate) {
        this.indate = indate;
    }

    @Override
    public String toString() {
        return "WhStorageD{" +
                "storebill='" + storebill + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", breadcode='" + breadcode + '\'' +
                ", warecode='" + warecode + '\'' +
                ", unitcode='" + unitcode + '\'' +
                ", plannum=" + plannum +
                ", itemnum=" + itemnum +
                ", fromTable='" + fromTable + '\'' +
                ", indate='" + indate + '\'' +
                '}';
    }
}