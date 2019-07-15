package com.obtk.wmsfly.bs.service;

import com.obtk.wmsfly.domain.BsVehicle;
import com.obtk.wmsfly.domain.BsWarehouse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BsVehicleService {
    List<BsVehicle> getVehicleAll(@Param("context") String context);
    int deleVehicle(List<String> ids);
    int addVehicle(BsVehicle bsVehicle);
    String getVehicleByMaxId();
    BsVehicle getVehicleById(String id);
    int updatebsVehicle(BsVehicle bsVehicle);
    String getBsVehicleMaxId();
}
