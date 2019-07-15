package com.obtk.wmsfly.domain;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class BsWarehouse {
    private String warecode;

    //仓库名称
    @NotBlank(message = "仓库名称不能为空")
    private String warename;
    //负责人
    private String dutyman;
    //所在城市
    private String city;
    //邮政编码
    @Length(max = 6,message = "邮政编码只能为6位数")
    private String postcode;
    //通讯地址
    private String addr;
    //手提电话
    private String tel;
    //联系人
    private String attnman;
    //电话
    private String mobiltel;
    //传呼机
    private String caller;
    //传真
    private String fax;
    //邮箱
    private String email;
    //备注
    private String remark;
    //面积
    private Long warearea;
    //各列X增量
    private Integer leftadd;
    //宽度
    private Integer width;
    //总行
    private Integer totalrow;
    //总列
    private Integer totalcol;
    //邮政地址
    private Integer rowadd;
    //高度
    private Integer height;
    //仓库性质
    private String kind;
    //仓库类型
    private String waretype;

    public String getWarecode() {
        return warecode;
    }

    public void setWarecode(String warecode) {
        this.warecode = warecode == null ? null : warecode.trim();
    }

    public String getWarename() {
        return warename;
    }

    public void setWarename(String warename) {
        this.warename = warename == null ? null : warename.trim();
    }

    public String getDutyman() {
        return dutyman;
    }

    public void setDutyman(String dutyman) {
        this.dutyman = dutyman == null ? null : dutyman.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
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

    public String getAttnman() {
        return attnman;
    }

    public void setAttnman(String attnman) {
        this.attnman = attnman == null ? null : attnman.trim();
    }

    public String getMobiltel() {
        return mobiltel;
    }

    public void setMobiltel(String mobiltel) {
        this.mobiltel = mobiltel == null ? null : mobiltel.trim();
    }

    public String getCaller() {
        return caller;
    }

    public void setCaller(String caller) {
        this.caller = caller == null ? null : caller.trim();
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Long getWarearea() {
        return warearea;
    }

    public void setWarearea(Long warearea) {
        this.warearea = warearea;
    }

    public Integer getLeftadd() {
        return leftadd;
    }

    public void setLeftadd(Integer leftadd) {
        this.leftadd = leftadd;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
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

    public Integer getRowadd() {
        return rowadd;
    }

    public void setRowadd(Integer rowadd) {
        this.rowadd = rowadd;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind == null ? null : kind.trim();
    }

    public String getWaretype() {
        return waretype;
    }

    public void setWaretype(String waretype) {
        this.waretype = waretype == null ? null : waretype.trim();
    }

    @Override
    public String toString() {
        return "BsWarehouse{" +
                "warecode='" + warecode + '\'' +
                ", warename='" + warename + '\'' +
                ", dutyman='" + dutyman + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", addr='" + addr + '\'' +
                ", tel='" + tel + '\'' +
                ", attnman='" + attnman + '\'' +
                ", mobiltel='" + mobiltel + '\'' +
                ", caller='" + caller + '\'' +
                ", fax='" + fax + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", warearea=" + warearea +
                ", leftadd=" + leftadd +
                ", width=" + width +
                ", totalrow=" + totalrow +
                ", totalcol=" + totalcol +
                ", rowadd=" + rowadd +
                ", height=" + height +
                ", kind='" + kind + '\'' +
                ", waretype='" + waretype + '\'' +
                '}';
    }
}