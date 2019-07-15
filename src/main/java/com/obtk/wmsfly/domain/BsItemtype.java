package com.obtk.wmsfly.domain;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.List;

public class BsItemtype {

    private String itemtypecode;

    private String upcode;

    private String oldcode;

    @NotBlank(message = "名称不能为空！")
    private String itemname;

    private String acccode;

    private String accname;

    private Integer step;

    private String state;

    private BigDecimal price;

    private List<BsItemtype> bsItemtypeList;

    public List<BsItemtype> getBsItemtypeList() {
        return bsItemtypeList;
    }

    public void setBsItemtypeList(List<BsItemtype> bsItemtypeList) {
        this.bsItemtypeList = bsItemtypeList;
    }

    public String getItemtypecode() {
        return itemtypecode;
    }

    public void setItemtypecode(String itemtypecode) {
        this.itemtypecode = itemtypecode == null ? null : itemtypecode.trim();
    }

    public String getUpcode() {
        return upcode;
    }

    public void setUpcode(String upcode) {
        this.upcode = upcode == null ? null : upcode.trim();
    }

    public String getOldcode() {
        return oldcode;
    }

    public void setOldcode(String oldcode) {
        this.oldcode = oldcode == null ? null : oldcode.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
    }

    public String getAcccode() {
        return acccode;
    }

    public void setAcccode(String acccode) {
        this.acccode = acccode == null ? null : acccode.trim();
    }

    public String getAccname() {
        return accname;
    }

    public void setAccname(String accname) {
        this.accname = accname == null ? null : accname.trim();
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "BsItemtype{" +
                "itemtypecode='" + itemtypecode + '\'' +
                ", upcode='" + upcode + '\'' +
                ", oldcode='" + oldcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", acccode='" + acccode + '\'' +
                ", accname='" + accname + '\'' +
                ", step=" + step +
                ", state='" + state + '\'' +
                ", price=" + price +
                ", bsItemtypeList=" + bsItemtypeList +
                '}';
    }
}