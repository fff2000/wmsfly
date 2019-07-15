package com.obtk.wmsfly.domain;

/**
 * 功能说明
 *
 * @author
 * @date 2019-07-03 15:02:39
 */
public class ElecInfo {
    String id;
    String uid;
    Integer eleType;
    Integer timeType;
    double price;
    UseElecType useElecType;

    public UseElecType getUseElecType() {
        return useElecType;
    }

    public void setUseElecType(UseElecType useElecType) {
        this.useElecType = useElecType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getEleType() {
        return eleType;
    }

    public void setEleType(Integer eleType) {
        this.eleType = eleType;
    }

    public Integer getTimeType() {
        return timeType;
    }

    public void setTimeType(Integer timeType) {
        this.timeType = timeType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ElecInfo{" +
                "id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", eleType=" + eleType +
                ", timeType=" + timeType +
                ", price=" + price +
                '}';
    }
}
