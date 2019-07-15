package com.obtk.wmsfly.bs.service;

import com.obtk.wmsfly.common.TreeBuilder;
import com.obtk.wmsfly.domain.BsItemtype;

import java.util.List;

public interface BsItemtypeService {

    List<TreeBuilder.Node> getBsItemtypesTree();

    List<BsItemtype> getBsItemtypeByupcode(BsItemtype bsItemtype);

    int delBsItemtypeById(String  ids);

    int addBsItemtype(BsItemtype bsItemtype);

    String getBsItemtypeMaxId();

    int updateBsItemtype(BsItemtype bsItemtype);

    String getBsItemtypeBy(String id);

    BsItemtype getBsItemtypeById(String id);

    BsItemtype getItemtypeBystate(String id);
}
