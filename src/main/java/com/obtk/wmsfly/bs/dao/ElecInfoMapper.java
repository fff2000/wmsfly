package com.obtk.wmsfly.bs.dao;

import com.obtk.wmsfly.domain.ElecInfo;
import com.obtk.wmsfly.domain.UseElecType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ElecInfoMapper {

    //查询所有
    List<ElecInfo> findElecInfo(@Param("id") String id);
    //单条删除
    int delElecInfo(String id);
    //添加
    int insertElectInfo(ElecInfo elecInfo);
    //查询用电类型
    List<UseElecType> findUseElecType();

}
