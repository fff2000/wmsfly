package com.obtk.wmsfly.domain;

import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

public class WhInbillH {
    //入库流水号
    private String inbillcode;
    //入库类型
    private String billtype;
    //采购单号
    private String oldbill;
    //仓库编码
    @NotBlank(message = "仓库不能为空！")
    private String warecode;
    //客户名称
    private String custname;
    //合同编号
    private String contactbill;
    //供应商名称
    private String supplyname;
    //提单号
    private String serverbill;
    //入库日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date indate;
    //验货人
    @NotBlank(message = "验货人不能为空！")
    private String tellman;
    //运输方式
    private String trantype;
    //承运商编码
    private String carrier;
    //承运车辆
    private String vehicle;
    //送货司机
    private String driver;
    //身份证号
    private String identifyId;
    //司机电话
    private String motormanTel;
    //备注
    private String remark;
    //制单人
    private String billman;
    //制单时间
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date billdate;
    //审核人
    private String stateman;
    //审核时间
    private Date statedate;
    //审核状态
    private String state;
    //所属部门
    private String depart;
    //车辆类型
    private String vehtype;
    //运费结算编号（结算时使用）
    private String runbill;
    //运输线路
    private String runline;
    //采购人
    private String inbuyman;
    //采购类型
    private String purtype;
    //装订号
    private String bindcode;
    //发单日期
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date senddate;

    //仓库
    BsWarehouse bsWarehouse;

    public BsWarehouse getBsWarehouse() {
        return bsWarehouse;
    }

    public void setBsWarehouse(BsWarehouse bsWarehouse) {
        this.bsWarehouse = bsWarehouse;
    }

    public String getInbillcode() {
        return inbillcode;
    }

    public void setInbillcode(String inbillcode) {
        this.inbillcode = inbillcode == null ? null : inbillcode.trim();
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype == null ? null : billtype.trim();
    }

    public String getOldbill() {
        return oldbill;
    }

    public void setOldbill(String oldbill) {
        this.oldbill = oldbill == null ? null : oldbill.trim();
    }

    public String getWarecode() {
        return warecode;
    }

    public void setWarecode(String warecode) {
        this.warecode = warecode == null ? null : warecode.trim();
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname == null ? null : custname.trim();
    }

    public String getContactbill() {
        return contactbill;
    }

    public void setContactbill(String contactbill) {
        this.contactbill = contactbill == null ? null : contactbill.trim();
    }

    public String getSupplyname() {
        return supplyname;
    }

    public void setSupplyname(String supplyname) {
        this.supplyname = supplyname == null ? null : supplyname.trim();
    }

    public String getServerbill() {
        return serverbill;
    }

    public void setServerbill(String serverbill) {
        this.serverbill = serverbill == null ? null : serverbill.trim();
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public String getTellman() {
        return tellman;
    }

    public void setTellman(String tellman) {
        this.tellman = tellman == null ? null : tellman.trim();
    }

    public String getTrantype() {
        return trantype;
    }

    public void setTrantype(String trantype) {
        this.trantype = trantype == null ? null : trantype.trim();
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier == null ? null : carrier.trim();
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle == null ? null : vehicle.trim();
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }

    public String getIdentifyId() {
        return identifyId;
    }

    public void setIdentifyId(String identifyId) {
        this.identifyId = identifyId == null ? null : identifyId.trim();
    }

    public String getMotormanTel() {
        return motormanTel;
    }

    public void setMotormanTel(String motormanTel) {
        this.motormanTel = motormanTel == null ? null : motormanTel.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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

    public String getStateman() {
        return stateman;
    }

    public void setStateman(String stateman) {
        this.stateman = stateman == null ? null : stateman.trim();
    }

    public Date getStatedate() {
        return statedate;
    }

    public void setStatedate(Date statedate) {
        this.statedate = statedate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart == null ? null : depart.trim();
    }

    public String getVehtype() {
        return vehtype;
    }

    public void setVehtype(String vehtype) {
        this.vehtype = vehtype == null ? null : vehtype.trim();
    }

    public String getRunbill() {
        return runbill;
    }

    public void setRunbill(String runbill) {
        this.runbill = runbill == null ? null : runbill.trim();
    }

    public String getRunline() {
        return runline;
    }

    public void setRunline(String runline) {
        this.runline = runline == null ? null : runline.trim();
    }

    public String getInbuyman() {
        return inbuyman;
    }

    public void setInbuyman(String inbuyman) {
        this.inbuyman = inbuyman == null ? null : inbuyman.trim();
    }

    public String getPurtype() {
        return purtype;
    }

    public void setPurtype(String purtype) {
        this.purtype = purtype == null ? null : purtype.trim();
    }

    public String getBindcode() {
        return bindcode;
    }

    public void setBindcode(String bindcode) {
        this.bindcode = bindcode == null ? null : bindcode.trim();
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    @Override
    public String toString() {
        return "WhInbillH{" +
                "inbillcode='" + inbillcode + '\'' +
                ", billtype='" + billtype + '\'' +
                ", oldbill='" + oldbill + '\'' +
                ", warecode='" + warecode + '\'' +
                ", custname='" + custname + '\'' +
                ", contactbill='" + contactbill + '\'' +
                ", supplyname='" + supplyname + '\'' +
                ", serverbill='" + serverbill + '\'' +
                ", indate=" + indate +
                ", tellman='" + tellman + '\'' +
                ", trantype='" + trantype + '\'' +
                ", carrier='" + carrier + '\'' +
                ", vehicle='" + vehicle + '\'' +
                ", driver='" + driver + '\'' +
                ", identifyId='" + identifyId + '\'' +
                ", motormanTel='" + motormanTel + '\'' +
                ", remark='" + remark + '\'' +
                ", billman='" + billman + '\'' +
                ", billdate=" + billdate +
                ", stateman='" + stateman + '\'' +
                ", statedate=" + statedate +
                ", state='" + state + '\'' +
                ", depart='" + depart + '\'' +
                ", vehtype='" + vehtype + '\'' +
                ", runbill='" + runbill + '\'' +
                ", runline='" + runline + '\'' +
                ", inbuyman='" + inbuyman + '\'' +
                ", purtype='" + purtype + '\'' +
                ", bindcode='" + bindcode + '\'' +
                ", senddate=" + senddate +
                ", bsWarehouse=" + bsWarehouse +
                '}';
    }
}