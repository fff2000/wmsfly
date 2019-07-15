package com.obtk.wmsfly.sys.service;

import com.obtk.wmsfly.domain.SysBbs;

import java.util.List;

/**
 * 功能说明
 *
 * @author fly
 * @date 2019-04-29 21:47:34
 */
public interface SysBbsService {
    public SysBbs findById(String bbsId) ;
    List<SysBbs> findByBbs(SysBbs bbs);

    Boolean insertBbs(SysBbs bbs);
    int deleteById(String ids);
    Boolean updateById(SysBbs bbs);
}
