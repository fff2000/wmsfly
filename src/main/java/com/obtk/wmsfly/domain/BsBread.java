package com.obtk.wmsfly.domain;

public class BsBread {
    private String breadcode;

    private String breadname;

    private String state;
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBreadcode() {
        return breadcode;
    }

    public void setBreadcode(String breadcode) {
        this.breadcode = breadcode == null ? null : breadcode.trim();
    }

    public String getBreadname() {
        return breadname;
    }

    public void setBreadname(String breadname) {
        this.breadname = breadname == null ? null : breadname.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    @Override
    public String toString() {
        return "BsBread{" +
                "breadcode='" + breadcode + '\'' +
                ", breadname='" + breadname + '\'' +
                ", state='" + state + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

}