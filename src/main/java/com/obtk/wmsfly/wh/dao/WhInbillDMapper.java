package com.obtk.wmsfly.wh.dao;

import com.obtk.wmsfly.domain.WhInbillD;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WhInbillDMapper {
    //查询最大ID值
    String getInbillDMaxId(String id);

    int insertInbillD(WhInbillD whInbillD);

    List<WhInbillD> getWhInbillD(@Param("result") String result);
    //根据入库流水查询
    List<WhInbillD> getWhInbillDById(String id);

    //根据从表id查询
    WhInbillD getWhInbillDAndId(@Param("rowno") String rowno,@Param("id") String id);

    int updateInbillD(WhInbillD whInbillD);

    int delInbillD(@Param("ids")List<String> ids,@Param("id") String id);

    //审核查询
    List<WhInbillD> getWhInbillDList(String id);
}