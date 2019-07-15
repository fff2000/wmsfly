package com.obtk.wmsfly.domain;

import javax.validation.constraints.NotBlank;

public class BsServeH {
    //供应商编码
    private String servecode;
    //供应商名称
    @NotBlank(message = "供应商名称不能为空！")
    private String servename;
    //法人代表
    private String header;
    //通讯地址
    private String addr;
    //联系电话
    private String tel;
    //联系人
    private String connecter;
    //手机
    private String mobiltel;
    //传真
    private String fax;
    //网址
    private String netaddr;
    //邮箱
    private String email;
    //供应类型
    private String custtype;
    //负责人
    private String principal;
    // 银行帐号
    private String accounts;
    //开 户 行
    private String bank;
    //纳税人国税识别号
    private String countrytax;

    public String getServecode() {
        return servecode;
    }

    public void setServecode(String servecode) {
        this.servecode = servecode == null ? null : servecode.trim();
    }

    public String getServename() {
        return servename;
    }

    public void setServename(String servename) {
        this.servename = servename == null ? null : servename.trim();
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header == null ? null : header.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getConnecter() {
        return connecter;
    }

    public void setConnecter(String connecter) {
        this.connecter = connecter == null ? null : connecter.trim();
    }

    public String getMobiltel() {
        return mobiltel;
    }

    public void setMobiltel(String mobiltel) {
        this.mobiltel = mobiltel == null ? null : mobiltel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getNetaddr() {
        return netaddr;
    }

    public void setNetaddr(String netaddr) {
        this.netaddr = netaddr == null ? null : netaddr.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype == null ? null : custtype.trim();
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal == null ? null : principal.trim();
    }

    public String getAccounts() {
        return accounts;
    }

    public void setAccounts(String accounts) {
        this.accounts = accounts == null ? null : accounts.trim();
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank == null ? null : bank.trim();
    }

    public String getCountrytax() {
        return countrytax;
    }

    public void setCountrytax(String countrytax) {
        this.countrytax = countrytax == null ? null : countrytax.trim();
    }

    @Override
    public String toString() {
        return "BsServeH{" +
                "servecode='" + servecode + '\'' +
                ", servename='" + servename + '\'' +
                ", header='" + header + '\'' +
                ", addr='" + addr + '\'' +
                ", tel='" + tel + '\'' +
                ", connecter='" + connecter + '\'' +
                ", mobiltel='" + mobiltel + '\'' +
                ", fax='" + fax + '\'' +
                ", netaddr='" + netaddr + '\'' +
                ", email='" + email + '\'' +
                ", custtype='" + custtype + '\'' +
                ", principal='" + principal + '\'' +
                ", accounts='" + accounts + '\'' +
                ", bank='" + bank + '\'' +
                ", countrytax='" + countrytax + '\'' +
                '}';
    }
}