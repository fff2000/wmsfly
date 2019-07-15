package com.obtk.wmsfly.wh.dao;

import com.obtk.wmsfly.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WhStorageMapper {

    //查询所有
    List<WhStorageD> queryAll(String id);

    //查询仓库
    List<BsWarehouse> queryWare();

    //查询材料名称
    List<BsNewitem> queryItem();

    //查询品牌名称
    List<BsBread> queryBread();

    List<WhStorage> findAll (@Param("result") String result);


}
