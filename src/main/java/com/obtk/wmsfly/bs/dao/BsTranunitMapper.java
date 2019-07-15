package com.obtk.wmsfly.bs.dao;

import com.obtk.wmsfly.domain.BsTranunit;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BsTranunitMapper {
    List<BsTranunit> findBsTranunitAll();

    List<BsTranunit> getBsTranunit(@Param("content") String content);

    int insertBsTranunit(BsTranunit bsTranunit);

    int updateBsTranunit(BsTranunit bsTranunit);

    String getBsTranunitMaxId();

    BsTranunit getBsTranunitById(String id);

    int delBsTranunit(@Param("ids") String ids);
}