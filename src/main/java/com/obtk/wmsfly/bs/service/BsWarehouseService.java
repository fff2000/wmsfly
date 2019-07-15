package com.obtk.wmsfly.bs.service;

import com.obtk.wmsfly.domain.BsWarehouse;

import java.util.List;

public interface BsWarehouseService {
    List<BsWarehouse> getWarehouseAll(String content);
    int deleWarehouse(List<String> ids);
    int addWarehouse (BsWarehouse bsWarehouse);
    String getWarehouseByMaxId();
    BsWarehouse getWarehouseById(String id);
    int updateWarehouse(BsWarehouse bsWarehouse);
}
