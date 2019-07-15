package com.obtk.wmsfly.bs.service.impl;

import com.obtk.wmsfly.bs.dao.BsItemtypeMapper;
import com.obtk.wmsfly.bs.dao.BsNewitemMapper;
import com.obtk.wmsfly.bs.service.BsNewitemService;
import com.obtk.wmsfly.domain.BsNewitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-25 14:57:14
 */
@Service
public class BsNewitemServiceImpl implements BsNewitemService {

    @Override
    public BsNewitem getBsNewitemById(String id) {
        return bsNewitemMapper.getBsNewitemById(id);
    }

    @Autowired
    BsNewitemMapper bsNewitemMapper;

    @Override
    public List<BsNewitem> findBsNewitemList(String id) {
        return bsNewitemMapper.findBsNewitemList(id);
    }

    @Override
    public int inserBsNewitem(BsNewitem bsNewitem) {
        return bsNewitemMapper.inserBsNewitem(bsNewitem);
    }

    @Override
    public String getBsNewitemMaxId() {
        return bsNewitemMapper.getBsNewitemMaxId();
    }

    @Override
    public int updateBsNewitem(BsNewitem bsNewitem) {
        return bsNewitemMapper.updateBsNewitem(bsNewitem);
    }

    @Override
    public int deleBsNewitemById(String id) {
        return bsNewitemMapper.deleBsNewitemById(id);
    }

    @Override
    public BsNewitem getNewitemBytypeId(String id) {
        return bsNewitemMapper.getNewitemBytypeId(id);
    }

    //查询所有
    @Override
    public  List<BsNewitem>  getBsNewitemAll() {
        return bsNewitemMapper.getBsNewitemAll();
    }

    //联合查询
    @Override
    public List<BsNewitem> getNewitemandtype(String name) {
        return bsNewitemMapper.getNewitemandtype(name);
    }
}
