package com.obtk.wmsfly.bs.dao;

import com.obtk.wmsfly.common.TreeBuilder;
import com.obtk.wmsfly.domain.BsItemtype;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BsItemtypeMapper {
    List<TreeBuilder.Node> getBsItemtypesTree();

    List<BsItemtype> getBsItemtypeByupcode(BsItemtype bsItemtype);

    int delBsItemtypeById(String ids);

    int addBsItemtype(BsItemtype bsItemtype);

    String getBsItemtypeMaxId();

    int updateBsItemtype(BsItemtype bsItemtype);

    BsItemtype getBsItemtypeById(String id);

    String getBsItemtypeBy(String id);
    //查询材料分类是否启用
    BsItemtype getItemtypeBystate(String id);
}