package com.obtk.wmsfly.domain;

import java.util.List;

/**
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 21:26:18
*/
public class SysBbs {

    private String bbsId;
    private String title;

    private String publicDate;
    private String stopDate;
    private String billMan;
    private String billDate;
    private String content;

    public List getSysBbs() {
        return SysBbs;
    }

    public void setSysBbs(List sysBbs) {
        SysBbs = sysBbs;
    }

    private List SysBbs;

    public String getBbsId() {
        return bbsId;
    }

    public void setBbsId(String bbsId) {
        this.bbsId = bbsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public String getStopDate() {
        return stopDate;
    }

    public void setStopDate(String stopDate) {
        this.stopDate = stopDate;
    }

    public String getBillMan() {
        return billMan;
    }

    public void setBillMan(String billMan) {
        this.billMan = billMan;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
