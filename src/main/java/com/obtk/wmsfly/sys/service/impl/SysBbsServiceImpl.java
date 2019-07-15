package com.obtk.wmsfly.sys.service.impl;

import com.obtk.wmsfly.domain.SysBbs;
import com.obtk.wmsfly.sys.dao.SysBbsMapper;
import com.obtk.wmsfly.sys.service.SysBbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysBbsServiceImpl implements SysBbsService {
    //依赖注入
    @Autowired
    SysBbsMapper bbsMapper;

    //根据主键查询记录
    @Override
    public SysBbs findById(String bbsId) {
        return bbsMapper.findById(bbsId);
    }

    @Override
    public List<SysBbs> findByBbs(SysBbs bbs) {

        return bbsMapper.findByBbs(bbs);
    }

    @Override
    public Boolean insertBbs(SysBbs bbs) {

        return bbsMapper.insertBbs(bbs);
    }

    @Override
    public int deleteById(String ids) {
        return bbsMapper.deleteById(ids);
    }

    @Override
    public Boolean updateById(SysBbs bbs) {
        return bbsMapper.updateById(bbs);
    }

    ;
}