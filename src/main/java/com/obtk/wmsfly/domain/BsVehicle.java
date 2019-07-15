package com.obtk.wmsfly.domain;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class BsVehicle {
    @NotBlank(message = "车牌不能为空！")
    private String vehicleid;

    @NotBlank(message = "运输单位不能为空！")
    private String trancode;

    private String vehiclecode;

    private String companyid;
    private String runcode;
    private String drivecode;

    private String buycode;

    private String city;

    private String plant;

    private Date makesdate;

    private String vehiclelong;
    private Long reallong;

    private String vehicletype;
    private Long realwide;

    private String plantmodel;

    private String framemodel;

    private String motormodel;
    private Long underpan;
    private Long loading;
    private Long maxloading;

    private String vehiclecolor;

    private Long runlong;

    private Date checkdate;

    @NotBlank(message = "驾驶员不能为空！")
    private String driver;

    @NotBlank(message = "驾驶员身份证不能为空！")
    private String driverid;

    private Date insuredate;

    private String remark;

    public String getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid == null ? null : vehicleid.trim();
    }

    public String getTrancode() {
        return trancode;
    }

    public void setTrancode(String trancode) {
        this.trancode = trancode == null ? null : trancode.trim();
    }

    public String getVehiclecode() {
        return vehiclecode;
    }

    public void setVehiclecode(String vehiclecode) {
        this.vehiclecode = vehiclecode == null ? null : vehiclecode.trim();
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid == null ? null : companyid.trim();
    }

    public String getRuncode() {
        return runcode;
    }

    public void setRuncode(String runcode) {
        this.runcode = runcode == null ? null : runcode.trim();
    }

    public String getDrivecode() {
        return drivecode;
    }

    public void setDrivecode(String drivecode) {
        this.drivecode = drivecode == null ? null : drivecode.trim();
    }

    public String getBuycode() {
        return buycode;
    }

    public void setBuycode(String buycode) {
        this.buycode = buycode == null ? null : buycode.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getPlant() {
        return plant;
    }

    public void setPlant(String plant) {
        this.plant = plant == null ? null : plant.trim();
    }

    public Date getMakesdate() {
        return makesdate;
    }

    public void setMakesdate(Date makesdate) {
        this.makesdate = makesdate;
    }

    public String getVehiclelong() {
        return vehiclelong;
    }

    public void setVehiclelong(String vehiclelong) {
        this.vehiclelong = vehiclelong == null ? null : vehiclelong.trim();
    }

    public Long getReallong() {
        return reallong;
    }

    public void setReallong(Long reallong) {
        this.reallong = reallong;
    }

    public String getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(String vehicletype) {
        this.vehicletype = vehicletype == null ? null : vehicletype.trim();
    }

    public Long getRealwide() {
        return realwide;
    }

    public void setRealwide(Long realwide) {
        this.realwide = realwide;
    }

    public String getPlantmodel() {
        return plantmodel;
    }

    public void setPlantmodel(String plantmodel) {
        this.plantmodel = plantmodel == null ? null : plantmodel.trim();
    }

    public String getFramemodel() {
        return framemodel;
    }

    public void setFramemodel(String framemodel) {
        this.framemodel = framemodel == null ? null : framemodel.trim();
    }

    public String getMotormodel() {
        return motormodel;
    }

    public void setMotormodel(String motormodel) {
        this.motormodel = motormodel == null ? null : motormodel.trim();
    }

    public Long getUnderpan() {
        return underpan;
    }

    public void setUnderpan(Long underpan) {
        this.underpan = underpan;
    }

    public Long getLoading() {
        return loading;
    }

    public void setLoading(Long loading) {
        this.loading = loading;
    }

    public Long getMaxloading() {
        return maxloading;
    }

    public void setMaxloading(Long maxloading) {
        this.maxloading = maxloading;
    }

    public String getVehiclecolor() {
        return vehiclecolor;
    }

    public void setVehiclecolor(String vehiclecolor) {
        this.vehiclecolor = vehiclecolor == null ? null : vehiclecolor.trim();
    }

    public Long getRunlong() {
        return runlong;
    }

    public void setRunlong(Long runlong) {
        this.runlong = runlong;
    }

    public Date getCheckdate() {
        return checkdate;
    }

    public void setCheckdate(Date checkdate) {
        this.checkdate = checkdate;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver == null ? null : driver.trim();
    }

    public String getDriverid() {
        return driverid;
    }

    public void setDriverid(String driverid) {
        this.driverid = driverid == null ? null : driverid.trim();
    }

    public Date getInsuredate() {
        return insuredate;
    }

    public void setInsuredate(Date insuredate) {
        this.insuredate = insuredate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}