package com.obtk.wmsfly.wh.dao;

import com.obtk.wmsfly.domain.WhOutbillD;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WhOutbillDMapper {

  //入库反审核删除数据
  int delWhOutbillD(@Param("id") String id);

}