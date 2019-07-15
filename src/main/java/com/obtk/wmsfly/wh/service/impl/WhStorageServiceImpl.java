package com.obtk.wmsfly.wh.service.impl;

import com.obtk.wmsfly.domain.*;
import com.obtk.wmsfly.wh.dao.WhStorageMapper;
import com.obtk.wmsfly.wh.service.IWhStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhStorageServiceImpl implements IWhStorageService {

    @Autowired
    private WhStorageMapper mapper;

    //查询所有
    @Override
    public List<WhStorageD> queryAll(String id) {
        return mapper.queryAll(id);
    }

    //查询仓库
    @Override
    public List<BsWarehouse> queryWare(){
        return mapper.queryWare();
    }

    public List<BsNewitem> queryItem(){
        return mapper.queryItem();
    }

    @Override
    public List<BsBread> queryBread() {
        return mapper.queryBread();
    }

    @Override
    public List<WhStorage> findAll(String result) {
        return mapper.findAll(result);
    }
}
