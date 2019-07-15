package com.obtk.wmsfly.bs.service;

import com.obtk.wmsfly.domain.ElecInfo;
import com.obtk.wmsfly.domain.UseElecType;

import java.util.List;

public interface ElecInfoService {
    //查询
    List<ElecInfo> findElecInfo(String id);

    //删除
    int delElecInfo(String id);

    //添加
    int insertElectInfo(ElecInfo elecInfo);

    List<UseElecType> findUseElecType();

}
