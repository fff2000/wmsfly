package com.obtk.wmsfly.wh.service.impl;

import com.obtk.wmsfly.domain.WhInbillD;
import com.obtk.wmsfly.domain.WhStorageD;
import com.obtk.wmsfly.wh.dao.WhOutbillDMapper;
import com.obtk.wmsfly.wh.dao.WhStorageDMapper;
import com.obtk.wmsfly.wh.service.WhStorageDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-06-08 22:20:38
 */
@Service
public class WhStorageDServiceImpl implements WhStorageDService {

    @Autowired
    WhStorageDMapper whStorageDMapper;

    @Autowired
    WhOutbillDMapper whOutbillDMapper;

    @Override
    public int insertWhStorageD(WhStorageD whStorageD) {
        return whStorageDMapper.insertWhStorageD(whStorageD);
    }

    @Override
    public int delWhStorageD(String id) {
               whOutbillDMapper.delWhOutbillD(id);
        return whStorageDMapper.delWhStorageD(id);
    }

    @Override
    public List<WhStorageD> findAll() {
        return whStorageDMapper.findAll();
    }
}
