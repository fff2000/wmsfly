package com.obtk.wmsfly.bs.dao;

import com.obtk.wmsfly.domain.BsServeH;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BsServeHMapper {
    List<BsServeH> listBsServe(@Param("result") String result) ;

    int insertBsServe(BsServeH bsServeH);

    String getBsServeMaxId();

    BsServeH getBsServeById(String id);

    int updateBsServe(BsServeH bsServeH);

    int delBsServe(@Param("id") String id);
}