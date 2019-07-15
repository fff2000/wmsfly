package com.obtk.wmsfly.domain;

/**
 * 功能说明
 *
 * @author
 * @date 2019-07-03 15:03:28
 */
public class UseElecType {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UseElecType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
