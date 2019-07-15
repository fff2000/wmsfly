package com.obtk.wmsfly.wh.service;

import com.obtk.wmsfly.domain.WhInbillD;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WhInbillDService {
    //查询最大ID值
    String getInbillDMaxId(String id);

    //添加信息
    int insertInbillD(WhInbillD whInbillD);

    List<WhInbillD> getWhInbillD(String result);
    //根据入库流水查询
    List<WhInbillD> getWhInbillDById(String id);
    //根据从表Id查询
    WhInbillD getWhInbillDAndId(@Param("rowno") String rowno, @Param("id") String id);

    int updateInbillD(WhInbillD whInbillD);

    int delInbillD(List<String> ids,String id);

    List<WhInbillD> getWhInbillDList(String id);
}
