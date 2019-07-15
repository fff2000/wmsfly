package com.obtk.wmsfly.bs.service.impl;

import com.obtk.wmsfly.bs.dao.ElecInfoMapper;
import com.obtk.wmsfly.bs.service.ElecInfoService;
import com.obtk.wmsfly.domain.ElecInfo;
import com.obtk.wmsfly.domain.UseElecType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-07-03 15:07:41
 */
@Service
public class ElecServiceImpl implements ElecInfoService {
    @Autowired
    ElecInfoMapper elecInfoMapper;

    @Override
    public List<ElecInfo> findElecInfo(String id) {
        return elecInfoMapper.findElecInfo(id);
    }

    @Override
    public int delElecInfo(String id) {
        return elecInfoMapper.delElecInfo(id);
    }

    @Override
    public int insertElectInfo(ElecInfo elecInfo) {
        return elecInfoMapper.insertElectInfo(elecInfo);
    }

    @Override
    public List<UseElecType> findUseElecType() {
        return elecInfoMapper.findUseElecType();
    }

}
