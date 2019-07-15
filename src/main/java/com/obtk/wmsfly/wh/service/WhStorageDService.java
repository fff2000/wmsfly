package com.obtk.wmsfly.wh.service;

import com.obtk.wmsfly.domain.WhStorageD;

import java.util.List;

public interface WhStorageDService {

    int insertWhStorageD(WhStorageD whStorageD);

    int delWhStorageD(String id);

    List<WhStorageD> findAll();
}
