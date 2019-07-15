package com.obtk.wmsfly.wh.dao;

import com.obtk.wmsfly.domain.BsWarehouse;
import com.obtk.wmsfly.domain.WhOutbillD;
import com.obtk.wmsfly.domain.WhOutbillH;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WhOutbillHMapper {
    //查询是否存在该出库材料
    WhOutbillD queryhaveItem(@Param("code") String code,@Param("id") String id);

    //修改存在的计划出库
    int updateHaveNum(@Param("num") String num, @Param("code") String code);

    //删除后修改计划数量
    int DelupdatePlanNum(String storebill);

    //删除批次出库
    public int DelOutBillD(String outbillcode);

    //反审核实际库存
    int updateFalseNum(@Param("num") String num,@Param("code") String code);

    //查询计划出库数量
    List<WhOutbillD> queryPlanNum(String code);

    //修改是否出库状态
    int updateOutBillhState(@Param("state") String state,@Param("code") String code);

    //修改实际库存
    int updateTrueNum(@Param("num") String num,@Param("planNum") String planNum,@Param("code") String code);

    //修改实际出库数量
    int updateItemNum(@Param("num") String num,@Param("code") String code);

    //插入到批次出库
    int InsertOutBillD(WhOutbillD whOutbillD);

    //查询材料列表
    List<WhOutbillD> queryOutItem(String id);

    //查询库存
    List<WhOutbillD> queryItemStorage();

    //查询材料名称
    String queryItemName(String code);

    //查询品牌名称
    String queryBread(String code);

    //修改材料
    int updateItem(WhOutbillH whOutbillH);

    //查询仓库名称
    List<BsWarehouse> queryWareName(String id);

    //查询所有
    List<WhOutbillH> queryAll();

    //查询要修改的信息
    WhOutbillH queryItem(String outBillCode);

    //修改计划数量
    int updateStorage(@Param("plannum") String plannum,@Param("id") String id);

    //增加
    int insertWhOutbillH(WhOutbillH whOutbillH);

    String  getWhOutbillHMaxId();
}
