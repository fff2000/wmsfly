package com.obtk.wmsfly.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class WhInbillD implements Serializable {
    //从表流水号
    private String rowno;
    //入库流水号
    private String inbillcode;
    //货物编码
    private String itemcode;
    //货物名称
    private String itemname;
    //品牌编码
    private String breadcode;
    //品牌名称
    private String breadname;
    //规格型号
    private String standard;
    //钢号
    private String steelNo;
    //生产厂家
    private String facCode;
    //计量单位
    private String unitCode;
    //实收数量
    private BigDecimal itemnum;
    //发货数量
    private BigDecimal sendNum;
    //入库件数
    private BigDecimal itemPiece;
    //单价
    private BigDecimal price;
    //总价
    private BigDecimal itemvalue;
    //条形码编号
    private String barcode;
    //备注
    private String cremark;
    //卡号
    private String carNo;
    //搬运价格
    private BigDecimal carryPrice;
    //运价
    private BigDecimal runPrice;
    //验货人
    private String checkman;
    //验货日期
    private Date checkdate;
    //是否参与成本
    private String isBlanace;
    //是否需要预估
    private String isPrize;
    //供应商核算单
    private String purveybill;
    //成本核算时间
    private Date balanceTme;
    //客户结算单号
    private String spebill;
    //是否错误单据
    private String isError;
    //是否参与月结
    private String isMonthbalance;
    //入库主表
    WhInbillH whInbillH;

    public String getRowno() {
        return rowno;
    }

    public void setRowno(String rowno) {
        this.rowno = rowno;
    }

    public String getInbillcode() {
        return inbillcode;
    }

    public void setInbillcode(String inbillcode) {
        this.inbillcode = inbillcode;
    }

    public String getItemcode() {
        return itemcode;
    }

    public void setItemcode(String itemcode) {
        this.itemcode = itemcode;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getBreadcode() {
        return breadcode;
    }

    public void setBreadcode(String breadcode) {
        this.breadcode = breadcode;
    }

    public String getBreadname() {
        return breadname;
    }

    public void setBreadname(String breadname) {
        this.breadname = breadname;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public String getSteelNo() {
        return steelNo;
    }

    public void setSteelNo(String steelNo) {
        this.steelNo = steelNo;
    }

    public String getFacCode() {
        return facCode;
    }

    public void setFacCode(String facCode) {
        this.facCode = facCode;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public BigDecimal getItemnum() {
        return itemnum;
    }

    public void setItemnum(BigDecimal itemnum) {
        this.itemnum = itemnum;
    }

    public BigDecimal getSendNum() {
        return sendNum;
    }

    public void setSendNum(BigDecimal sendNum) {
        this.sendNum = sendNum;
    }

    public BigDecimal getItemPiece() {
        return itemPiece;
    }

    public void setItemPiece(BigDecimal itemPiece) {
        this.itemPiece = itemPiece;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getItemvalue() {
        return itemvalue;
    }

    public void setItemvalue(BigDecimal itemvalue) {
        this.itemvalue = itemvalue;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getCremark() {
        return cremark;
    }

    public void setCremark(String cremark) {
        this.cremark = cremark;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public BigDecimal getCarryPrice() {
        return carryPrice;
    }

    public void setCarryPrice(BigDecimal carryPrice) {
        this.carryPrice = carryPrice;
    }

    public BigDecimal getRunPrice() {
        return runPrice;
    }

    public void setRunPrice(BigDecimal runPrice) {
        this.runPrice = runPrice;
    }

    public String getCheckman() {
        return checkman;
    }

    public void setCheckman(String checkman) {
        this.checkman = checkman;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getIsBlanace() {
        return isBlanace;
    }

    public void setIsBlanace(String isBlanace) {
        this.isBlanace = isBlanace;
    }

    public String getIsPrize() {
        return isPrize;
    }

    public void setIsPrize(String isPrize) {
        this.isPrize = isPrize;
    }

    public String getPurveybill() {
        return purveybill;
    }

    public void setPurveybill(String purveybill) {
        this.purveybill = purveybill;
    }

    public Date getBalanceTme() {
        return balanceTme;
    }

    public void setBalanceTme(Date balanceTme) {
        this.balanceTme = balanceTme;
    }

    public String getSpebill() {
        return spebill;
    }

    public void setSpebill(String spebill) {
        this.spebill = spebill;
    }

    public String getIsError() {
        return isError;
    }

    public void setIsError(String isError) {
        this.isError = isError;
    }

    public String getIsMonthbalance() {
        return isMonthbalance;
    }

    public void setIsMonthbalance(String isMonthbalance) {
        this.isMonthbalance = isMonthbalance;
    }

    public WhInbillH getWhInbillH() {
        return whInbillH;
    }

    public void setWhInbillH(WhInbillH whInbillH) {
        this.whInbillH = whInbillH;
    }

    @Override
    public String toString() {
        return "WhInbillD{" +
                "rowno='" + rowno + '\'' +
                ", inbillcode='" + inbillcode + '\'' +
                ", itemcode='" + itemcode + '\'' +
                ", itemname='" + itemname + '\'' +
                ", breadcode='" + breadcode + '\'' +
                ", breadname='" + breadname + '\'' +
                ", standard='" + standard + '\'' +
                ", steelNo='" + steelNo + '\'' +
                ", facCode='" + facCode + '\'' +
                ", unitCode='" + unitCode + '\'' +
                ", itemnum=" + itemnum +
                ", sendNum=" + sendNum +
                ", itemPiece=" + itemPiece +
                ", price=" + price +
                ", itemvalue=" + itemvalue +
                ", barcode='" + barcode + '\'' +
                ", cremark='" + cremark + '\'' +
                ", carNo='" + carNo + '\'' +
                ", carryPrice=" + carryPrice +
                ", runPrice=" + runPrice +
                ", checkman='" + checkman + '\'' +
                ", checkdate=" + checkdate +
                ", isBlanace='" + isBlanace + '\'' +
                ", isPrize='" + isPrize + '\'' +
                ", purveybill='" + purveybill + '\'' +
                ", balanceTme=" + balanceTme +
                ", spebill='" + spebill + '\'' +
                ", isError='" + isError + '\'' +
                ", isMonthbalance='" + isMonthbalance + '\'' +
                ", whInbillH=" + whInbillH +
                '}';
    }
}