package com.obtk.wmsfly.wh.dao;

import com.obtk.wmsfly.domain.WhInbillD;
import com.obtk.wmsfly.domain.WhStorageD;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface WhStorageDMapper {
    //审核之后添加库存材料明细表
    int insertWhStorageD(WhStorageD whStorageD);

    //反审核之后删除库存材料明细表
    int delWhStorageD(@Param("id") String id);

    List<WhStorageD> findAll ();
    
}