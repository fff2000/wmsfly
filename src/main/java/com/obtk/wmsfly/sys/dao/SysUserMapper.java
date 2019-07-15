package com.obtk.wmsfly.sys.dao;

import com.obtk.wmsfly.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 21:27:45
 */
@Mapper    //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface SysUserMapper {
    SysUser findByUsername(String username);
}
