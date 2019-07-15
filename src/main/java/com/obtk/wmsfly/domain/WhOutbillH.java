package com.obtk.wmsfly.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

public class WhOutbillH {
    private String outbillcode;//配送出库单号

    private String sendbill;//发运单号

    private String salebill;//销售单号

    private String contactbill;//销售合同

    private String tag;//标段名称

    private String custCode;//客户编码

    private String custtype;//客户类型

    private String wareCode;//仓库编码

    private String projectCode;//项目名称

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date outdate;//出库日期

    private String pickbill;//配送单号

    private String tellMan;//提货人

    private String identifyId;//身份证号码

    private String carrier;//公司

    private String state;//审核状态

    private String depart;//所属部门

    private String billtype;//出库类型

    private String vehicle;//提货车号

    private String driver;//提货司机

    private String motormanTel;//司机电话

    private String remark;//备注

    private String billman;//制单人

    private String stateman;//审核人

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date billdate;//制单日期

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date statedate;//审核日期

    private String tranType;//运输方式

    private String inputFlag;//

    private String vehType;//车辆类型

    private String sendType;//出库方式

    private String runbill;//运输单号

    private String runline;//运输路线

    private BigDecimal runprice;//运输单价

    private String rununit;//运输件数

    private String runcontact;//运输合同号

    private String runstate;//运输状态

    private String supplyCode;//供应商编码

    private String batchBill;//

    private String planCode;//计划单号

    private String bindCode;//装订号

    private String inwareCode;

    private String isToware;

    private Date balanceDate;

    private String spebill;//客户结算单号

    private String isError;//是否错误单据

    private WhOutbillD whOutbillD;

    public String getOutbillcode() {
        return outbillcode;
    }

    public void setOutbillcode(String outbillcode) {
        this.outbillcode = outbillcode;
    }

    public String getSendbill() {
        return sendbill;
    }

    public void setSendbill(String sendbill) {
        this.sendbill = sendbill;
    }

    public String getSalebill() {
        return salebill;
    }

    public void setSalebill(String salebill) {
        this.salebill = salebill;
    }

    public String getContactbill() {
        return contactbill;
    }

    public void setContactbill(String contactbill) {
        this.contactbill = contactbill;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getCustCode() {
        return custCode;
    }

    public void setCustCode(String custCode) {
        this.custCode = custCode;
    }

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }

    public String getWareCode() {
        return wareCode;
    }

    public void setWareCode(String wareCode) {
        this.wareCode = wareCode;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public Date getOutdate() {
        return outdate;
    }

    public void setOutdate(Date outdate) {
        this.outdate = outdate;
    }

    public String getPickbill() {
        return pickbill;
    }

    public void setPickbill(String pickbill) {
        this.pickbill = pickbill;
    }

    public String getTellMan() {
        return tellMan;
    }

    public void setTellMan(String tellMan) {
        this.tellMan = tellMan;
    }

    public String getIdentifyId() {
        return identifyId;
    }

    public void setIdentifyId(String identifyId) {
        this.identifyId = identifyId;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getBilltype() {
        return billtype;
    }

    public void setBilltype(String billtype) {
        this.billtype = billtype;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getMotormanTel() {
        return motormanTel;
    }

    public void setMotormanTel(String motormanTel) {
        this.motormanTel = motormanTel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBillman() {
        return billman;
    }

    public void setBillman(String billman) {
        this.billman = billman;
    }

    public String getStateman() {
        return stateman;
    }

    public void setStateman(String stateman) {
        this.stateman = stateman;
    }

    public Date getBilldate() {
        return billdate;
    }

    public void setBilldate(Date billdate) {
        this.billdate = billdate;
    }

    public Date getStatedate() {
        return statedate;
    }

    public void setStatedate(Date statedate) {
        this.statedate = statedate;
    }

    public String getTranType() {
        return tranType;
    }

    public void setTranType(String tranType) {
        this.tranType = tranType;
    }

    public String getInputFlag() {
        return inputFlag;
    }

    public void setInputFlag(String inputFlag) {
        this.inputFlag = inputFlag;
    }

    public String getVehType() {
        return vehType;
    }

    public void setVehType(String vehType) {
        this.vehType = vehType;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getRunbill() {
        return runbill;
    }

    public void setRunbill(String runbill) {
        this.runbill = runbill;
    }

    public String getRunline() {
        return runline;
    }

    public void setRunline(String runline) {
        this.runline = runline;
    }

    public BigDecimal getRunprice() {
        return runprice;
    }

    public void setRunprice(BigDecimal runprice) {
        this.runprice = runprice;
    }

    public String getRununit() {
        return rununit;
    }

    public void setRununit(String rununit) {
        this.rununit = rununit;
    }

    public String getRuncontact() {
        return runcontact;
    }

    public void setRuncontact(String runcontact) {
        this.runcontact = runcontact;
    }

    public String getRunstate() {
        return runstate;
    }

    public void setRunstate(String runstate) {
        this.runstate = runstate;
    }

    public String getSupplyCode() {
        return supplyCode;
    }

    public void setSupplyCode(String supplyCode) {
        this.supplyCode = supplyCode;
    }

    public String getBatchBill() {
        return batchBill;
    }

    public void setBatchBill(String batchBill) {
        this.batchBill = batchBill;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getBindCode() {
        return bindCode;
    }

    public void setBindCode(String bindCode) {
        this.bindCode = bindCode;
    }

    public String getInwareCode() {
        return inwareCode;
    }

    public void setInwareCode(String inwareCode) {
        this.inwareCode = inwareCode;
    }

    public String getIsToware() {
        return isToware;
    }

    public void setIsToware(String isToware) {
        this.isToware = isToware;
    }

    public Date getBalanceDate() {
        return balanceDate;
    }

    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
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

    public WhOutbillD getWhOutbillD() {
        return whOutbillD;
    }

    public void setWhOutbillD(WhOutbillD whOutbillD) {
        this.whOutbillD = whOutbillD;
    }
}