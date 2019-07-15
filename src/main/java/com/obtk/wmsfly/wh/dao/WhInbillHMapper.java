package com.obtk.wmsfly.wh.dao;

import com.obtk.wmsfly.domain.WhInbillH;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WhInbillHMapper {

     List<WhInbillH> getWhInbillH();

    //查询最大id
    String getWhIndillHMaxId();
    //增加
    int insertWhIndillH(WhInbillH whInbillH);

    //根据id查询数据
    WhInbillH getWhInbillHById(String id);

    int updateInbillH(WhInbillH whInbillH);

    int updateInbillHState(String id);

    int delInbillH(String id);
    //查询是否为审核状态
    WhInbillH getInbillHState(String id);
    //反审核
    int updateInbillHreverseState(String id);

    //材料是否出库
    int getWhoutbilhState(@Param("id") String id);
}