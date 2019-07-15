package com.obtk.wmsfly.bs.service.impl;

import com.obtk.wmsfly.bs.dao.BsTranunitMapper;
import com.obtk.wmsfly.bs.service.BsTranunitService;
import com.obtk.wmsfly.domain.BsTranunit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-26 17:42:55
 */
@Service
public class BsTranunitServiceImpl implements BsTranunitService {

    @Autowired
    BsTranunitMapper bsTranunitMapper;

    @Override
    public List<BsTranunit> findBsTranunitAll() {
        return bsTranunitMapper.findBsTranunitAll();
    }

    @Override
    public List<BsTranunit> getBsTranunit(String content) {
        return bsTranunitMapper.getBsTranunit(content);
    }

    @Override
    public int insertBsTranunit(BsTranunit bsTranunit) {
        return bsTranunitMapper.insertBsTranunit(bsTranunit);
    }

    @Override
    public int updateBsTranunit(BsTranunit bsTranunit) {
        return bsTranunitMapper.updateBsTranunit(bsTranunit);
    }

    @Override
    public String getBsTranunitMaxId() {
        return bsTranunitMapper.getBsTranunitMaxId();
    }

    @Override
    public BsTranunit getBsTranunitById(String id) {
        return bsTranunitMapper.getBsTranunitById(id);
    }

    @Override
    public int delBsTranunit(String ids) {
        return bsTranunitMapper.delBsTranunit(ids);
    }
}
