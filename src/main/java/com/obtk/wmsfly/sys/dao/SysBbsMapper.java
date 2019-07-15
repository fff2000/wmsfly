package com.obtk.wmsfly.sys.dao;

import com.obtk.wmsfly.domain.SysBbs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 21:27:45
 */
@Mapper    //声明是一个Mapper,与springbootApplication中的@MapperScan二选一写上即可
@Repository
public interface SysBbsMapper {
    String  ids = "" ;
    //根据条件查询数据
    List<SysBbs> findByBbs(SysBbs bbs);
    Boolean insertBbs(SysBbs bbs);
    //增加@Param("ids")  解决 org.apache.ibatis.reflection.ReflectionException: There is no getter for
    int deleteById(@Param("ids") String ids);
    Boolean updateById(SysBbs bbs);
    //根据主键查询记录
    SysBbs findById(@Param("bbsId") String bbsId);
}
