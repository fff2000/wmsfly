package com.obtk.wmsfly.bs.dao;

import com.obtk.wmsfly.domain.BsBread;
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
public interface BsBreadMapper {
    List<BsBread> findByAll(@Param("context") String context);

    List<BsBread> findBystate(@Param("context") String context);

    Boolean updateById(BsBread bs);

    BsBread findById(String breadCode);

    int deleteById(@Param("ids") String ids);

    Boolean insertBs(BsBread bs);

    List<BsBread> getBsbreeadName();

    String getBsbreadMaxId();
}
