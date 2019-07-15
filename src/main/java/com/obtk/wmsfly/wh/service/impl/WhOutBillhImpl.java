package com.obtk.wmsfly.wh.service.impl;

import com.obtk.wmsfly.domain.BsWarehouse;
import com.obtk.wmsfly.domain.WhOutbillD;
import com.obtk.wmsfly.domain.WhOutbillH;
import com.obtk.wmsfly.wh.dao.WhOutbillHMapper;
import com.obtk.wmsfly.wh.service.IWhOutBillH;
import org.apache.ibatis.transaction.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.math.BigDecimal;
import java.util.List;

@Service
public class WhOutBillhImpl implements IWhOutBillH {

    @Autowired
    private WhOutbillHMapper mapper;

    //新增到批次出库
    @Override
    public int InsertOutBillD(WhOutbillD whOutbillD) {
        return mapper.InsertOutBillD(whOutbillD);
    }

    //查询是否存在批次出库记录
    @Override
    public WhOutbillD queryhaveItem(String code,String id) {
        return mapper.queryhaveItem(code,id);
    }

    //修改存在计划数量
    @Override
    public int updateHaveNum(String num, String code) {
        return mapper.updateHaveNum(num,code);
    }

    //选择材料入库
    @Transactional
    @Override
    public boolean ItemOutHandle(WhOutbillD whOutbillD, String[] plannum, String[] id) {
        int i = updateStorage(plannum,id);//修改计划库存
//      int j = InsertOutBillD(whOutbillD);//插入到批次出库
        System.out.println(whOutbillD.getOutbillcode());
        int j = 0;
        for(int y = 0;y < plannum.length;y++){
            if(!plannum[y].trim().equals("") && plannum[y].length() != 0){
                if(queryhaveItem(whOutbillD.getOutbillcode(),id[y]) == null){
                    j = InsertOutBillD(getWhOutBillD(id[y],plannum[y],whOutbillD.getOutbillcode()));//测试插入到批次出库
                }else{
                    j = updateHaveNum(plannum[y],id[y]);
                }
            }
        }
        if(j == 0 || i == 0){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动事物回滚
            return false;
        }
        return true;
    }

    //修改实际出库
    @Override
    public int updateItemNum(String num, String code) {
        return mapper.updateItemNum(num,code);
    }

    //修改出库状态
    @Override
    public int updateOutBillhState(String state,String code) {
        return mapper.updateOutBillhState(state,code);
    }

    //修改实际库存
    @Override
    public int updateTrueNum(String num,String planNum,String code) {
        return mapper.updateTrueNum(num,planNum,code);
    }

    //查询计划数量
    @Override
    public List<WhOutbillD> queryPlanNum(String code) {
        return mapper.queryPlanNum(code);
    }

    //审核
    @Override
    @Transactional
    public boolean checkItem(String plannum, String outbillcode, String storebill) {
        try{
            List<WhOutbillD> list = queryPlanNum(outbillcode);
            Integer itemNum = 0;//实际出库数量
            int trueNum = 0;//实际库存数量
            for (WhOutbillD item: list) {
                System.out.println(item.getPlanNum());
                System.out.println(item.getStorebill());
            updateItemNum(item.getPlanNum().toString(),item.getStorebill());//修改实际出库
            updateTrueNum(item.getPlanNum().toString(),item.getPlanNum().toString(),item.getStorebill());//修改真实库存
//            itemNum += item.getPlanNum().intValue();//计划数量累加
            }
        updateOutBillhState("1",outbillcode);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动事物回滚
            return false;
        }
        return true;
    }

    //反审核
    @Transactional
    @Override
    public boolean ReturnItem(String outbillcode, String storebill) {
        try {
            List<WhOutbillD> list = queryPlanNum(outbillcode);
            Integer num = 0;//实际出库数量
            for (WhOutbillD item: list) {
                updateItemNum("0",item.getStorebill());//修改实际出库
                num = item.getPlanNum().intValue();
                updateFalseNum(num.toString(),item.getStorebill());//修改实际库存
            }
            updateOutBillhState("0",outbillcode);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动事物回滚
            return false;
        }
        return true;
    }

    @Override
    public int updateFalseNum(String num, String code) {
        return mapper.updateFalseNum(num,code);
    }

    //选择材料插入数据的来源
    @Override
    public WhOutbillD getWhOutBillD(String id, String num,String outbillcode) {
        WhOutbillD whOutbillD = new WhOutbillD();
        whOutbillD.setStorebill(id);
        whOutbillD.setOutbillcode(outbillcode);
        whOutbillD.setItemcode("000001");
        whOutbillD.setBreadcode("195");
//        whOutbillD.setBreadname(queryBread(whOutbillD.getBreadcode()));
        whOutbillD.setBreadname("钢绞线12.7");
//        whOutbillD.setItemcode(queryItemName(whOutbillD.getItemcode()));
        whOutbillD.setItemname("钢铁公司");
        whOutbillD.setPlanNum(new BigDecimal(num));
        whOutbillD.setItemnum(new BigDecimal("0"));
        whOutbillD.setItemPiece(new BigDecimal(1));
        return whOutbillD;
    }

    //查询材料名称
    @Override
    public String queryItemName(String code){
        return mapper.queryItemName(code);
    }

    // 查询品牌名称
    @Override
    public String queryBread(String code) {
        return mapper.queryBread(code);
    }

    //查询材料列表
    @Override
    public List<WhOutbillD> queryOutItem(String id) {
        return mapper.queryOutItem(id);
    }

    //修改库存
    @Override
    public int updateStorage(String[] plannum, String[] id) {
        int j = 0;
        for (int i = 0; i < plannum.length; i++) {
            if(!"".equals(plannum[i]) && plannum[i] != null){
                j += mapper.updateStorage(plannum[i],id[i]);
            }
        }
        return j;
//        return mapper.updateStorage(plannum,id);
    }

    //查询所有
    @Override
    public List<WhOutbillH> queryAll() {
        return mapper.queryAll();
    }

    //查询要修改的
    @Override
    public WhOutbillH queryItem(String outBillCode) {
        return mapper.queryItem(outBillCode);
    }

    //查询仓库名称
    @Override
    public List<BsWarehouse> queryWareName(String id) {
        return mapper.queryWareName(id);
    }

    //修改
    @Override
    public int updateItem(WhOutbillH whOutbillH) {
        if(whOutbillH.getOutbillcode() == null || "".equals(whOutbillH.getOutbillcode().trim())){
            return 0;
        }
        if(whOutbillH.getProjectCode() == null || "".equals(whOutbillH.getProjectCode().trim())){
            return 0;
        }
        if(whOutbillH.getWareCode() == null || "".equals(whOutbillH.getWareCode().trim())){
            return 0;
        }
        return mapper.updateItem(whOutbillH);
    }

    //查询库存
    @Override
    public List<WhOutbillD> queryItemStorage() {
        return mapper.queryItemStorage();
    }


    //删除批次出库
    @Override
    public int DelOutBillD(String outbillcode) {
        return mapper.DelOutBillD(outbillcode);
    }

    //删除后修改计划数量
    @Override
    public int DelupdatePlanNum(String storebill) {
        return mapper.DelupdatePlanNum(storebill);
    }

    @Override
    public int insertWhOutbillH(WhOutbillH whOutbillH) {
        return mapper.insertWhOutbillH(whOutbillH);
    }

    public String getWhOutbillHMaxId(){
        return mapper.getWhOutbillHMaxId();
    }

    //删除
    @Transactional
    @Override
    public boolean DelItem(String storebill,String outbillcode) {
        try{
            System.out.println(storebill);
            int i = DelOutBillD(storebill);//删除批次出库数据
            int j = DelupdatePlanNum(storebill);//修改计划数量
            if(i == 0 || j == 0){
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动事物回滚
            }
            return true;
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动事物回滚
            return false;
        }

    }
}
