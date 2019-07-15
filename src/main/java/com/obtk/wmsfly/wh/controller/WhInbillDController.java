package com.obtk.wmsfly.wh.controller;

import com.obtk.wmsfly.bs.service.BsBreadService;
import com.obtk.wmsfly.bs.service.BsNewitemService;
import com.obtk.wmsfly.common.StringUtilsDiy;
import com.obtk.wmsfly.domain.BsBread;
import com.obtk.wmsfly.domain.BsNewitem;
import com.obtk.wmsfly.domain.MsgFb;
import com.obtk.wmsfly.domain.WhInbillD;
import com.obtk.wmsfly.wh.service.WhInbillDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-06-07 18:33:37
 */
@Controller
@RequestMapping("/inbillD")
public class WhInbillDController {

    //材料信息
    @Autowired
    BsNewitemService bsNewitemService;
    //品牌信息
    @Autowired
    BsBreadService bsBreadService;
    //入库材料信息
    @Autowired
    WhInbillDService whInbillDService;

    @RequestMapping("/toItemUpdate")
    public String itemUpdate(HttpServletRequest request, Model model){
        String rowno = request.getParameter("rowno");
        String id = request.getParameter("id");
        System.out.println(id);
        System.out.println(rowno);
        //查询材料信息
        List<BsNewitem> newitemAll = bsNewitemService.getBsNewitemAll();
        //查询品牌信息
        List<BsBread> bsbreeadName = bsBreadService.getBsbreeadName();
        //查询入库材料信息
        WhInbillD item = whInbillDService.getWhInbillDAndId(rowno,id);
        model.addAttribute("newitem",newitemAll);
        model.addAttribute("bread",bsbreeadName);
        model.addAttribute("item",item);
        model.addAttribute("id",id);
        return "wh/inbill/itemUpdate";
    }

    @RequestMapping(value = "/updateInbill", method = RequestMethod.POST)
    @ResponseBody
    public String updateInbill(@RequestBody WhInbillD whInbillD, Model model){
        int i = whInbillDService.updateInbillD(whInbillD);
        if(i > 0){
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/del/{id}/{inbillId}")
    @ResponseBody
    public String delInbillD(@PathVariable(value = "id") String id,@PathVariable("inbillId")String inbillid){
        System.out.println(inbillid);
        List<String> list = new ArrayList<String>();
        String [] str = id.split(",");
        for (String item : str){
            list.add(item);
        }
        int i = whInbillDService.delInbillD(list,inbillid);
        if(i > 0){
            return "success";
        }
        return "fail";
    }
}
