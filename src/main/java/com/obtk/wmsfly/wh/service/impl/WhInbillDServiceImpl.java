package com.obtk.wmsfly.wh.service.impl;

import com.obtk.wmsfly.domain.WhInbillD;
import com.obtk.wmsfly.wh.dao.WhInbillDMapper;
import com.obtk.wmsfly.wh.service.WhInbillDService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-06-05 18:43:42
 */
@Service
public class WhInbillDServiceImpl implements WhInbillDService {

    @Autowired
    WhInbillDMapper whInbillDMapper;

    @Override
    public String getInbillDMaxId(String id) {
        return whInbillDMapper.getInbillDMaxId(id);
    }

    @Override
    public int insertInbillD(WhInbillD whInbillD) {
        return whInbillDMapper.insertInbillD(whInbillD);
    }

    @Override
    public List<WhInbillD> getWhInbillD(String result) {
        return whInbillDMapper.getWhInbillD(result);
    }

    @Override
    public List<WhInbillD> getWhInbillDById(String id) {
        return whInbillDMapper.getWhInbillDById(id);
    }

    @Override
    public int updateInbillD(WhInbillD whInbillD) {
        return whInbillDMapper.updateInbillD(whInbillD);
    }

    @Override
    public WhInbillD getWhInbillDAndId(String rowno, String id) {
        return whInbillDMapper.getWhInbillDAndId(rowno,id);
    }

    @Override
    public int delInbillD(List<String> ids,String id) {
        return whInbillDMapper.delInbillD(ids,id);
    }

    @Override
    public List<WhInbillD> getWhInbillDList(String id) {
        return whInbillDMapper.getWhInbillDList(id);
    }
}
