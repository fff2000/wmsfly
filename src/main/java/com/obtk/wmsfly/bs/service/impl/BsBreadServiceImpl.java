package com.obtk.wmsfly.bs.service.impl;

import com.obtk.wmsfly.bs.dao.BsBreadMapper;
import com.obtk.wmsfly.bs.service.BsBreadService;
import com.obtk.wmsfly.domain.BsBread;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BsBreadServiceImpl implements BsBreadService {


    @Override
    public Boolean insertBs(BsBread bs) {
        return breadMapper.insertBs(bs);
    }

    @Override
    public List<BsBread> findByAll(@Param("context") String context) {
        return breadMapper.findByAll(context);
    }

    @Override
    public List<BsBread> findBystate(@Param("context") String context) {
        return breadMapper.findBystate(context);
    }

    //依赖注入
    @Autowired
    BsBreadMapper breadMapper;



    @Override
    public BsBread findById(String  breadCode){
        return breadMapper.findById(breadCode
        );

    }

    @Override
    public Boolean updateById(BsBread bs) {
        return breadMapper.updateById(bs);
    }

    @Override
    public int deleteById(String ids) {
        return breadMapper.deleteById(ids);
    }


    @Override
    public List<BsBread> getBsbreeadName() {
        return breadMapper.getBsbreeadName();
    }

    @Override
    public String getBsbreadMaxId() {
        return breadMapper.getBsbreadMaxId();
    }
}