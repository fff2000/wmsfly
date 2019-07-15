package com.obtk.wmsfly.bs.service;

import com.obtk.wmsfly.domain.BsTranunit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BsTranunitService {
    List<BsTranunit> findBsTranunitAll();

    List<BsTranunit> getBsTranunit(@Param("content")String content);

    int insertBsTranunit(BsTranunit bsTranunit);

    int updateBsTranunit(BsTranunit bsTranunit);

    String getBsTranunitMaxId();

    BsTranunit getBsTranunitById(String id);

    int delBsTranunit(String ids);
}
