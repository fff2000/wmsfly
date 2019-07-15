package com.obtk.wmsfly.domain;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class BsTranunit {
    //承运商编码
    private String trancode;
    //承运商名称
    @NotBlank(message = "运输单位不能为空！")
    private String tranname;
    //所在城市
    private String city;
    //业务联系人
    @NotBlank(message = "业务联系人不能为空！")
    private String connecter;
    //联系电话
    private String tel;
    //传真
    private String fax;
    //运输能力
    private String tranpower;
    //通讯地址
    private String addr;
    //备注
    private String memo;
    //法人代表
    private String corporation;
    //国税号
    private String taxcode;
    //营业执照
    private String charter;
    //注册资金
//    @NotBlank(message = "注册资金不能为空！")
    @NotNull(message = "注册资金不能为空！")
    private BigDecimal enrol;
    //联系人名称
    private String linkman;
    //联系人电话
    private String linktel;
    //公司网址
    private String httpadr;
    //负责人手机
    @NotBlank(message = "负责人手机不能为空！")
    private String principaltel;
    //开户帐号
    private String accounts;
    //开户银行
    private String bank;

    public String getTrancode() {
        return trancode;
    }

    public void setTrancode(String trancode) {
        this.trancode = trancode == null ? null : trancode.trim();
    }

    public String getTranname() {
        return tranname;
    }

    public void setTranname(String tranname) {
        this.tranname = tranname == null ? null : tranname.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getConnecter() {
        return connecter;
    }

    public void setConnecter(String connecter) {
        this.connecter = connecter == null ? null : connecter.trim();
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

    public String getTranpower() {
        return tranpower;
    }

    public void setTranpower(String tranpower) {
        this.tranpower = tranpower == null ? null : tranpower.trim();
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    public String getCorporation() {
        return corporation;
    }

    public void setCorporation(String corporation) {
        this.corporation = corporation == null ? null : corporation.trim();
    }

    public String getTaxcode() {
        return taxcode;
    }

    public void setTaxcode(String taxcode) {
        this.taxcode = taxcode == null ? null : taxcode.trim();
    }

    public String getCharter() {
        return charter;
    }

    public void setCharter(String charter) {
        this.charter = charter == null ? null : charter.trim();
    }

    public BigDecimal getEnrol() {
        return enrol;
    }

    public void setEnrol(BigDecimal enrol) {
        this.enrol = enrol;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLinktel() {
        return linktel;
    }

    public void setLinktel(String linktel) {
        this.linktel = linktel == null ? null : linktel.trim();
    }

    public String getHttpadr() {
        return httpadr;
    }

    public void setHttpadr(String httpadr) {
        this.httpadr = httpadr == null ? null : httpadr.trim();
    }

    public String getPrincipaltel() {
        return principaltel;
    }

    public void setPrincipaltel(String principaltel) {
        this.principaltel = principaltel == null ? null : principaltel.trim();
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

    @Override
    public String toString() {
        return "BsTranunit{" +
                "trancode='" + trancode + '\'' +
                ", tranname='" + tranname + '\'' +
                ", city='" + city + '\'' +
                ", connecter='" + connecter + '\'' +
                ", tel='" + tel + '\'' +
                ", fax='" + fax + '\'' +
                ", tranpower='" + tranpower + '\'' +
                ", addr='" + addr + '\'' +
                ", memo='" + memo + '\'' +
                ", corporation='" + corporation + '\'' +
                ", taxcode='" + taxcode + '\'' +
                ", charter='" + charter + '\'' +
                ", enrol=" + enrol +
                ", linkman='" + linkman + '\'' +
                ", linktel='" + linktel + '\'' +
                ", httpadr='" + httpadr + '\'' +
                ", principaltel='" + principaltel + '\'' +
                ", accounts='" + accounts + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }
}