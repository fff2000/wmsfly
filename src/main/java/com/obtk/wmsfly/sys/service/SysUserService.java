package com.obtk.wmsfly.sys.service;

import com.obtk.wmsfly.domain.SysUser;

/**
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 21:47:34
 */
public interface SysUserService {
    SysUser getUser(String username);
}
