package com.obtk.wmsfly.bs.dao;

import com.obtk.wmsfly.domain.BsNewitem;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BsNewitemMapper {
     List<BsNewitem> findBsNewitemList(String id);

     int inserBsNewitem(BsNewitem bsNewitem);

     String getBsNewitemMaxId();

     int updateBsNewitem(BsNewitem bsNewitem);

     BsNewitem getBsNewitemById(String id);

     int deleBsNewitemById(String id);

     BsNewitem getNewitemBytypeId(String id);
     //查询所有
     List<BsNewitem> getBsNewitemAll();
     //联合查询
     List<BsNewitem> getNewitemandtype(@Param("name") String name);

}