package com.obtk.wmsfly.wh.service.impl;

import com.obtk.wmsfly.domain.WhInbillH;
import com.obtk.wmsfly.domain.WhOutbillD;
import com.obtk.wmsfly.wh.dao.WhInbillHMapper;
import com.obtk.wmsfly.wh.dao.WhOutbillDMapper;
import com.obtk.wmsfly.wh.service.WhIndillHService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-29 15:48:27
 */
@Service
public class WhIndillHServiceImpl implements WhIndillHService {

    @Autowired
    WhInbillHMapper whInbillHMapper;
    @Override
    public List<WhInbillH> findWhIndillH() {
        return whInbillHMapper.getWhInbillH();
    }


    @Override
    public String getWhIndillHMaxId() {
        return whInbillHMapper.getWhIndillHMaxId();
    }

    @Override
    public int insertWhIndillH(WhInbillH whInbillH) {
        return whInbillHMapper.insertWhIndillH(whInbillH);
    }

    @Override
    public WhInbillH getWhInbillHById(String id) {
        return whInbillHMapper.getWhInbillHById(id);
    }

    @Override
    public int updateInbillH(WhInbillH whInbillH) {
        return whInbillHMapper.updateInbillH(whInbillH);
    }

    @Override
    public int updateInbillHState(String id) {
        return whInbillHMapper.updateInbillHState(id);
    }

    @Override
    public int delInbillH(String id) {
        return whInbillHMapper.delInbillH(id);
    }

    @Override
    public WhInbillH getInbillHState(String id) {
        return whInbillHMapper.getInbillHState(id);
    }

    @Override
    public int updateInbillHreverseState(String id) {
        return whInbillHMapper.updateInbillHreverseState(id);
    }

    @Override
    public int getWhoutbilhState(String id) {
        return whInbillHMapper.getWhoutbilhState(id);
    }

}
