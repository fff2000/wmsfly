package com.obtk.wmsfly.wh.service;

import com.obtk.wmsfly.domain.BsWarehouse;
import com.obtk.wmsfly.domain.WhOutbillD;
import com.obtk.wmsfly.domain.WhOutbillH;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface IWhOutBillH {

    //修改计划数量
    int updateStorage(String[] plannum, String[] id);

    //查询材料列表
    List<WhOutbillD> queryOutItem(String id);

    //插入到批次出库
    int InsertOutBillD(WhOutbillD whOutbillD);

    //修改计划数量并且插入到出库
    @Transactional
    boolean ItemOutHandle(WhOutbillD whOutbillD, String[] plannum, String[] id);

    //查询计划出库数量
    List<WhOutbillD> queryPlanNum(String code);

    //审核
    @Transactional
    boolean checkItem(String plannum, String outbillcode, String storebill);

    //反审核
    @Transactional
    boolean ReturnItem(String outbillcode, String storebill);

    //反审核实际库存
    int updateFalseNum(String num, String code);

    //返回插入出库数据
    WhOutbillD getWhOutBillD(String id, String num, String outbillcode);

    //查询所有
    List<WhOutbillH> queryAll();

    //查询要修改的信息
    WhOutbillH queryItem(String outBillCode);

    //查询仓库名称
    List<BsWarehouse> queryWareName(String id);

    //修改材料
    int updateItem(WhOutbillH whOutbillH);

    //修改实际库存
    int updateTrueNum(String num, String planNum, String code);

    //修改是否出库状态
    int updateOutBillhState(String state, String code);

    //修改实际出库数量
    int updateItemNum(String num, String code);

    //查询库存
    List<WhOutbillD> queryItemStorage();

    //查询是否存在该出库材料
    WhOutbillD queryhaveItem(String code,String id);

    //修改存在的计划出库
    int updateHaveNum(String num, String code);

    //删除批出库
    int DelOutBillD(String outbillcode);

    //删除后修改计划数量
    int DelupdatePlanNum(String storebill);

    //查询材料名称
    String queryItemName(String code);

    String  getWhOutbillHMaxId();

    //查询品牌名称
    String queryBread(String code);

    //增加
    int insertWhOutbillH(WhOutbillH whOutbillH);

    //删除
    @Transactional
    boolean DelItem(String storebill, String outbillcode);
}
