package com.obtk.wmsfly.bs.service;

import com.obtk.wmsfly.domain.BsBread;
import com.obtk.wmsfly.domain.SysBbs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 21:47:34
 */
public interface BsBreadService {


    Boolean insertBs(BsBread bs);

    List<BsBread> findByAll(@Param("context") String context);

    List<BsBread> findBystate(@Param("context") String context);
    //根据主键查询
    BsBread findById(String breadcode);

    Boolean updateById(BsBread bs);

    int deleteById(String ids);

    List<BsBread> getBsbreeadName();

    String getBsbreadMaxId();
}
