package com.obtk.wmsfly.domain;

/**
 * 功能说明
 *code=true 返回结果为真
 * code=false
 * @author fly
 * @date 2019-04-29 21:26:18
*/
public class MsgFb {
    public boolean isCode;
    private String msg;

    public boolean isCode() {
        return isCode;
    }

    public void setCode(boolean code) {
        isCode = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
