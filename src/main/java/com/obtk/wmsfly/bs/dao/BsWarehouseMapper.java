package com.obtk.wmsfly.bs.dao;

import com.obtk.wmsfly.domain.BsWarehouse;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BsWarehouseMapper {
    List<BsWarehouse> getWarehouseAll(@Param("content")String content);

    int deleWarehouse(List<String> ids);
    //增加
    int addWarehouse(BsWarehouse bsWarehouse);

    String getWarehouseByMaxId();

    BsWarehouse getWarehouseById(String id);

    int updateWarehouse(BsWarehouse bsWarehouse);
}