package com.obtk.wmsfly.domain;

import java.math.BigDecimal;

public class BsWareBlock {
    private String warecode;

    private String blockcode;

    private String blockname;

    private String blocktype;

    private String widthno;

    private String lengthno;

    private BigDecimal blockwidth;

    private BigDecimal blocklength;

    private BigDecimal blockarea;

    private String imagefile;

    private String imagefile1;

    private String remark;

    private Integer totalrow;

    private Integer totalcol;

    private Integer width;

    private Integer rowadd;

    private BigDecimal capacity;

    private BigDecimal storenum;

    public String getWarecode() {
        return warecode;
    }

    public void setWarecode(String warecode) {
        this.warecode = warecode == null ? null : warecode.trim();
    }

    public String getBlockcode() {
        return blockcode;
    }

    public void setBlockcode(String blockcode) {
        this.blockcode = blockcode == null ? null : blockcode.trim();
    }

    public String getBlockname() {
        return blockname;
    }

    public void setBlockname(String blockname) {
        this.blockname = blockname == null ? null : blockname.trim();
    }

    public String getBlocktype() {
        return blocktype;
    }

    public void setBlocktype(String blocktype) {
        this.blocktype = blocktype == null ? null : blocktype.trim();
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

    public BigDecimal getBlockwidth() {
        return blockwidth;
    }

    public void setBlockwidth(BigDecimal blockwidth) {
        this.blockwidth = blockwidth;
    }

    public BigDecimal getBlocklength() {
        return blocklength;
    }

    public void setBlocklength(BigDecimal blocklength) {
        this.blocklength = blocklength;
    }

    public BigDecimal getBlockarea() {
        return blockarea;
    }

    public void setBlockarea(BigDecimal blockarea) {
        this.blockarea = blockarea;
    }

    public String getImagefile() {
        return imagefile;
    }

    public void setImagefile(String imagefile) {
        this.imagefile = imagefile == null ? null : imagefile.trim();
    }

    public String getImagefile1() {
        return imagefile1;
    }

    public void setImagefile1(String imagefile1) {
        this.imagefile1 = imagefile1 == null ? null : imagefile1.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getTotalrow() {
        return totalrow;
    }

    public void setTotalrow(Integer totalrow) {
        this.totalrow = totalrow;
    }

    public Integer getTotalcol() {
        return totalcol;
    }

    public void setTotalcol(Integer totalcol) {
        this.totalcol = totalcol;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getRowadd() {
        return rowadd;
    }

    public void setRowadd(Integer rowadd) {
        this.rowadd = rowadd;
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