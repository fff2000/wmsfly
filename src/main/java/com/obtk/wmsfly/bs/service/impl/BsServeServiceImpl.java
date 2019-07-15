package com.obtk.wmsfly.bs.service.impl;

import com.obtk.wmsfly.bs.dao.BsServeHMapper;
import com.obtk.wmsfly.bs.service.BsServeService;
import com.obtk.wmsfly.domain.BsServeH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-26 14:49:15
 */
@Service
public class BsServeServiceImpl implements BsServeService {

    @Autowired
    BsServeHMapper bsServeHMapper;

    @Override
    public List<BsServeH> listBsServe(String result) {
        return bsServeHMapper.listBsServe(result);
    }

    @Override
    public int insertBsServe(BsServeH bsServeH) {
        return bsServeHMapper.insertBsServe(bsServeH);
    }

    @Override
    public String getBsServeMaxId() {
        return bsServeHMapper.getBsServeMaxId();
    }

    @Override
    public BsServeH getBsServeById(String id) {
        return bsServeHMapper.getBsServeById(id);
    }

    @Override
    public int updateBsServe(BsServeH bsServeH) {
        return bsServeHMapper.updateBsServe(bsServeH);
    }

    @Override
    public int delBsServe(String id) {
        return bsServeHMapper.delBsServe(id);
    }
}
