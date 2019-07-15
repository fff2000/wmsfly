package com.obtk.wmsfly.bs.service.impl;

import com.obtk.wmsfly.bs.dao.BsWarehouseMapper;
import com.obtk.wmsfly.bs.service.BsWarehouseService;
import com.obtk.wmsfly.domain.BsWarehouse;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-14 15:06:52
 */
@Service
public class BsWarehouseServiceImpl implements BsWarehouseService {

    @Autowired
    BsWarehouseMapper bsWarehouseMapper;

    @Override
    public int updateWarehouse(BsWarehouse bsWarehouse) {
        return bsWarehouseMapper.updateWarehouse(bsWarehouse);
    }

    @Override
    public BsWarehouse getWarehouseById(String id) {
        return bsWarehouseMapper.getWarehouseById(id);
    }

    @Override
    public String getWarehouseByMaxId() {
        return bsWarehouseMapper.getWarehouseByMaxId();
    }

    @Override
    public int addWarehouse(BsWarehouse bsWarehouse) {
        return bsWarehouseMapper.addWarehouse(bsWarehouse);
    }

    @Override
    @Transactional
    public int deleWarehouse(List<String> ids) {
        return bsWarehouseMapper.deleWarehouse(ids);
    }

    @Override
    public List<BsWarehouse> getWarehouseAll(String content) {
        return bsWarehouseMapper.getWarehouseAll(content);
    }
}
