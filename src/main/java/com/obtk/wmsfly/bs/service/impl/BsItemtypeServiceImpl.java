package com.obtk.wmsfly.bs.service.impl;

import com.obtk.wmsfly.bs.dao.BsItemtypeMapper;
import com.obtk.wmsfly.bs.service.BsItemtypeService;
import com.obtk.wmsfly.common.TreeBuilder;
import com.obtk.wmsfly.domain.BsItemtype;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-21 17:11:57
 */
@Service
public class BsItemtypeServiceImpl implements BsItemtypeService {

    @Autowired
    BsItemtypeMapper bsItemtypeMapper;

    @Override
    public List<BsItemtype> getBsItemtypeByupcode(BsItemtype bsItemtype) {
        return bsItemtypeMapper.getBsItemtypeByupcode(bsItemtype);
    }

    @Override
    public  List<TreeBuilder.Node> getBsItemtypesTree() {
        return bsItemtypeMapper.getBsItemtypesTree();
    }

    @Override
    public int addBsItemtype(BsItemtype bsItemtype) {
        return bsItemtypeMapper.addBsItemtype(bsItemtype);
    }

    @Override
    public int delBsItemtypeById(String  ids) {
        return bsItemtypeMapper.delBsItemtypeById(ids);
    }

    @Override
    public String getBsItemtypeMaxId() {
        return bsItemtypeMapper.getBsItemtypeMaxId();
    }

    @Override
    public int updateBsItemtype(BsItemtype bsItemtype) {
        return bsItemtypeMapper.updateBsItemtype(bsItemtype);
    }

    @Override
    public BsItemtype getBsItemtypeById(String id) {
        return bsItemtypeMapper.getBsItemtypeById(id);
    }

    @Override
    public String getBsItemtypeBy(String id) {
        return bsItemtypeMapper.getBsItemtypeBy(id);
    }

    @Override
    public BsItemtype getItemtypeBystate(String id) {
        return bsItemtypeMapper.getItemtypeBystate(id);
    }
}
