package com.obtk.wmsfly.bs.service;

import com.obtk.wmsfly.domain.BsServeH;

import java.util.List;

public interface BsServeService {
    List<BsServeH> listBsServe(String result);

    int insertBsServe(BsServeH bsServeH);

    String getBsServeMaxId();

    BsServeH getBsServeById(String id);

    int updateBsServe(BsServeH bsServeH);

    int delBsServe(String id);
}
