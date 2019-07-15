package com.obtk.wmsfly.bs.dao;

import com.obtk.wmsfly.domain.BsVehicle;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BsVehicleMapper {
    List<BsVehicle> getVehicleAll(@Param("context") String context);

    int deleVehicle(List<String> ids);
    //增加
    int addVehicle(BsVehicle bsVehicle);

    String getVehicleByMaxId();

    BsVehicle getVehicleById(String id);

    int updatebsVehicle(BsVehicle bsVehicle);

    String getBsVehicleMaxId();
}