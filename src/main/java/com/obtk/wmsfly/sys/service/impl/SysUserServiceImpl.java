package com.obtk.wmsfly.sys.service.impl;

import com.obtk.wmsfly.domain.SysUser;
import com.obtk.wmsfly.sys.dao.SysUserMapper;
import com.obtk.wmsfly.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {
    //依赖注入
    @Autowired
    SysUserMapper userMapper;

    @Override
    public SysUser getUser(String username) {
        return userMapper.findByUsername(username);
    }
}