package com.obtk.wmsfly.domain;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

public class BsNewitem {
    //材料编码
    private String itemcode;
    //材料分类编码
    private String itemtypecode;
    //材料名称
    @NotBlank(message = "材料名不能为空！")
    private String itemname;
    //助记码
    private String oldcode;
    //品牌编码
    @NotBlank(message = "品牌不能为空！")
    private String breadcode;
    //等    级
    private String gradecode;
    //单    位
    private String unitcode;
    //单位数量
    private Integer unitnum;
    //长
    private BigDecimal itemlen;
    //宽
    private BigDecimal width;
    //高
    private BigDecimal height;
    //重    量
    private BigDecimal weight;
    //体积（方）
    private BigDecimal volumn;
    //总价值
    private BigDecimal itemvalue;
    //是否启用
    private String state;
    //销售单价
    private BigDecimal saleprice;
    //税率
    private BigDecimal taxrate;

    private String itemnum;
    //材料分类
    BsItemtype bsItemtype;

    public String getItemnum() {
        return itemnum;
    }

    public void setItemnum(String itemnum) {
        this.itemnum = itemnum;
    }

    public BsItemtype getBsItemtype() {
        return bsItemtype;
    }

    public void setBsItemtype(BsItemtype bsItemtype) {
        this.bsItemtype = bsItemtype;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode == null ? null : itemcode.trim();
    }

    public String getItemtypecode() {
        return itemtypecode;
    }

    public void setItemtypecode(String itemtypecode) {
        this.itemtypecode = itemtypecode == null ? null : itemtypecode.trim();
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname == null ? null : itemname.trim();
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

    public String getGradecode() {
        return gradecode;
    }

    public void setGradecode(String gradecode) {
        this.gradecode = gradecode == null ? null : gradecode.trim();
    }

    public String getUnitcode() {
        return unitcode;
    }

    public void setUnitcode(String unitcode) {
        this.unitcode = unitcode == null ? null : unitcode.trim();
    }

    public Integer getUnitnum() {
        return unitnum;
    }

    public void setUnitnum(Integer unitnum) {
        this.unitnum = unitnum;
    }

    public BigDecimal getItemlen() {
        return itemlen;
    }

    public void setItemlen(BigDecimal itemlen) {
        this.itemlen = itemlen;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getVolumn() {
        return volumn;
    }

    public void setVolumn(BigDecimal volumn) {
        this.volumn = volumn;
    }

    public BigDecimal getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(BigDecimal itemvalue) {
        this.itemvalue = itemvalue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public BigDecimal getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(BigDecimal saleprice) {
        this.saleprice = saleprice;
    }

    public BigDecimal getTaxrate() {
        return taxrate;
    }

    public void setTaxrate(BigDecimal taxrate) {
        this.taxrate = taxrate;
    }

    @Override
    public String toString() {
        return "BsNewitem{" +
                "itemcode='" + itemcode + '\'' +
                ", itemtypecode='" + itemtypecode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", oldcode='" + oldcode + '\'' +
                ", breadcode='" + breadcode + '\'' +
                ", gradecode='" + gradecode + '\'' +
                ", unitcode='" + unitcode + '\'' +
                ", unitnum=" + unitnum +
                ", itemlen=" + itemlen +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                ", volumn=" + volumn +
                ", itemvalue=" + itemvalue +
                ", state='" + state + '\'' +
                ", saleprice=" + saleprice +
                ", taxrate=" + taxrate +
                ", bsItemtype=" + bsItemtype +
                '}';
    }
}