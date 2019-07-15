package com.obtk.wmsfly.sys.controller;

/**
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 21:52:01
 */

import com.obtk.wmsfly.domain.MsgFb;
import com.obtk.wmsfly.domain.SysUser;
import com.obtk.wmsfly.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
//声明这是Controller层
@Controller
public class SysUserController {
    //依赖注入
    @Autowired
    SysUserService userService;

    /**
     * 用户登录判断:
     * 成功：MsgFb code=true，
     * 失败：MsgFb code=false，停留在登录页面，并给予提示。
     */
    @RequestMapping("/login")
    @ResponseBody
    MsgFb login(SysUser user, Map<String, Object> model) {
        SysUser users = userService.getUser(user.getUsername());
        MsgFb msg = new MsgFb();
        msg.setCode(true);
        //判断用户名与数据库是否一致
        if (null != users ) {
            if (user.getUserPass().equals(users.getUserPass())) {
                msg.setCode(true);
            }else{
                msg.setCode(false);
                msg.setMsg("密码错误！！");
            }
        } else {
            msg.setCode(false);
            msg.setMsg("用户名不能为空或用户名不存在！！");
        }
        return msg;
    }

    //登陆成功后访问页面
    @RequestMapping(value = "/loginOk")
    public String loginOk() {
        return "/oastyle/index.html";
    }

    @RequestMapping(value = "/info")
    public String info() {
        return "/oastyle/info.html";
    }

    //修改密码
    @RequestMapping(value = "/uptpass")
    public String uptpass() {
        return "/oastyle/pass.html";
    }

    //查看个人资料
    @RequestMapping(value = "/personnew")
    public String personnews() {
        return "/oastyle/personnew.html";
    }
}