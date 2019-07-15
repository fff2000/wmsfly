package com.obtk.wmsfly.bs.service.impl;

import com.obtk.wmsfly.bs.dao.BsVehicleMapper;
import com.obtk.wmsfly.bs.service.BsVehicleService;
import com.obtk.wmsfly.domain.BsVehicle;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BsVehicleServiceImpl  implements BsVehicleService {

    @Autowired
    BsVehicleMapper bsVehicleMapper;


    @Override
    public List<BsVehicle> getVehicleAll(@Param("context") String context) {
        return bsVehicleMapper.getVehicleAll(context);
    }

    @Override
    public int deleVehicle(List<String> ids) {
        return bsVehicleMapper.deleVehicle(ids);
    }

    @Override
    public int addVehicle(BsVehicle bsVehicle) {
        return bsVehicleMapper.addVehicle(bsVehicle);
    }

    @Override
    public String getVehicleByMaxId() {
        return bsVehicleMapper.getVehicleByMaxId();
    }

    @Override
    public BsVehicle getVehicleById(String id) {
        return bsVehicleMapper.getVehicleById(id);
    }

    @Override
    public int updatebsVehicle(BsVehicle bsVehicle) {
        return bsVehicleMapper.updatebsVehicle(bsVehicle);
    }

    @Override
    public String getBsVehicleMaxId() {
        return bsVehicleMapper.getVehicleByMaxId();
    }
}
