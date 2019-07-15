package com.obtk.wmsfly.domain;

public class BsBuilder {
    private String buildercode;

    private String buildername;

    private String linkman;

    private String linkmanduty;

    private String sgaddr;

    private String tel;

    private String fax;

    private String email;

    private String http;

    private String accounts;

    private String bank;

    private String countrytax;

    public String getBuildercode() {
        return buildercode;
    }

    public void setBuildercode(String buildercode) {
        this.buildercode = buildercode == null ? null : buildercode.trim();
    }

    public String getBuildername() {
        return buildername;
    }

    public void setBuildername(String buildername) {
        this.buildername = buildername == null ? null : buildername.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinkmanduty() {
        return linkmanduty;
    }

    public void setLinkmanduty(String linkmanduty) {
        this.linkmanduty = linkmanduty == null ? null : linkmanduty.trim();
    }

    public String getSgaddr() {
        return sgaddr;
    }

    public void setSgaddr(String sgaddr) {
        this.sgaddr = sgaddr == null ? null : sgaddr.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getHttp() {
        return http;
    }

    public void setHttp(String http) {
        this.http = http == null ? null : http.trim();
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
}