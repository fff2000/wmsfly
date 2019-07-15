package com.obtk.wmsfly.wh.service;

import com.obtk.wmsfly.domain.*;

import java.util.List;

public interface IWhStorageService {

    //查询所有
    List<WhStorageD> queryAll(String id);

    //查询仓库
    List<BsWarehouse> queryWare();

    List<BsNewitem> queryItem();

    //查询品牌名称
    List<BsBread> queryBread();

    //查询台账
    List<WhStorage> findAll(String result);
}
