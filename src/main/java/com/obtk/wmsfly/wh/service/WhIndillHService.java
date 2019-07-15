package com.obtk.wmsfly.wh.service;

import com.obtk.wmsfly.domain.WhInbillH;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WhIndillHService {
     List<WhInbillH> findWhIndillH();
    //查询最大id
    String getWhIndillHMaxId();
    //增加
    int insertWhIndillH(WhInbillH whInbillH);

    WhInbillH getWhInbillHById(String id);

    int updateInbillH(WhInbillH whInbillH);

    int updateInbillHState(String id);

    int delInbillH(String id);
    //查询是否为审核状态
    WhInbillH getInbillHState(String id);

    //反审核
    int updateInbillHreverseState(String id);

    int getWhoutbilhState(String id);


}
