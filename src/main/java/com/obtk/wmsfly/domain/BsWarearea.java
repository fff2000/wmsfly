package com.obtk.wmsfly.domain;

import java.math.BigDecimal;

public class BsWarearea {
    private String warecode;

    private String areatype;

    private String areacode;

    private String blockcode;

    private String areaname;

    private String areano;

    private String widthno;

    private String lengthno;

    private String layerno;

    private BigDecimal areawidth;

    private BigDecimal arealength;

    private BigDecimal areaarea;

    private String barcode;

    private String remark;

    private BigDecimal capacity;

    private BigDecimal storenum;

    public String getWarecode() {
        return warecode;
    }

    public void setWarecode(String warecode) {
        this.warecode = warecode == null ? null : warecode.trim();
    }

    public String getAreatype() {
        return areatype;
    }

    public void setAreatype(String areatype) {
        this.areatype = areatype == null ? null : areatype.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getBlockcode() {
        return blockcode;
    }

    public void setBlockcode(String blockcode) {
        this.blockcode = blockcode == null ? null : blockcode.trim();
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
    }

    public String getAreano() {
        return areano;
    }

    public void setAreano(String areano) {
        this.areano = areano == null ? null : areano.trim();
    }

    public String getWidthno() {
        return widthno;
    }

    public void setWidthno(String widthno) {
        this.widthno = widthno == null ? null : widthno.trim();
    }

    public String getLengthno() {
        return lengthno;
    }

    public void setLengthno(String lengthno) {
        this.lengthno = lengthno == null ? null : lengthno.trim();
    }

    public String getLayerno() {
        return layerno;
    }

    public void setLayerno(String layerno) {
        this.layerno = layerno == null ? null : layerno.trim();
    }

    public BigDecimal getAreawidth() {
        return areawidth;
    }

    public void setAreawidth(BigDecimal areawidth) {
        this.areawidth = areawidth;
    }

    public BigDecimal getArealength() {
        return arealength;
    }

    public void setArealength(BigDecimal arealength) {
        this.arealength = arealength;
    }

    public BigDecimal getAreaarea() {
        return areaarea;
    }

    public void setAreaarea(BigDecimal areaarea) {
        this.areaarea = areaarea;
    }

    public String getbarcode() {
        return barcode;
    }

    public void setbarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public BigDecimal getStorenum() {
        return storenum;
    }

    public void setStorenum(BigDecimal storenum) {
        this.storenum = storenum;
    }
}