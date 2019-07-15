package com.obtk.wmsfly.domain;

import java.util.Date;

public class BsFactory {
    private String factorycode;

    private String factoryname;

    private String state;

    private String billman;

    private Date billdate;

    public String getFactorycode() {
        return factorycode;
    }

    public void setFactorycode(String factorycode) {
        this.factorycode = factorycode == null ? null : factorycode.trim();
    }

    public String getFactoryname() {
        return factoryname;
    }

    public void setFactoryname(String factoryname) {
        this.factoryname = factoryname == null ? null : factoryname.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getBillman() {
        return billman;
    }

    public void setBillman(String billman) {
        this.billman = billman == null ? null : billman.trim();
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }
}