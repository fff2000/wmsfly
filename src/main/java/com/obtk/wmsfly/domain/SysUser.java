package com.obtk.wmsfly.domain;

/**
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 21:26:18
 */
/*
由于Lombok插件的原因只需要
@Data：生成所有，getter() setter() toString()等等方法
@Setter ：生成setter()方法
@Getter：生成getter()方法
*/
public class SysUser {

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    private String username;

    private String userPass;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
