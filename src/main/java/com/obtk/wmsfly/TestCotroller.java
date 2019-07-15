package com.obtk.wmsfly;

import com.obtk.wmsfly.domain.SysUser;
import com.obtk.wmsfly.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 19:03:41
        */
@Controller
public class TestCotroller {
    @Autowired
    SysUserService sysUserService;
    @RequestMapping("/")
    String index(){
           return "/oastyle/login.html";
    }
}
