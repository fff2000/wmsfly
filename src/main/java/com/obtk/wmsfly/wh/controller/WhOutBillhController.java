package com.obtk.wmsfly.wh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.service.BsServeService;
import com.obtk.wmsfly.domain.*;
import com.obtk.wmsfly.wh.service.IWhOutBillH;
import com.obtk.wmsfly.wh.service.IWhStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/outH")
public class WhOutBillhController {

    @Autowired
    private IWhOutBillH service;

    @Autowired
    IWhStorageService iWhStorageService;

    @Autowired
    BsServeService bsServeService;
    //查询所有
    @RequestMapping("/Index")
    public String Index(Model model,
                              @RequestParam(value = "start",defaultValue = "1")int start,
                              @RequestParam(value = "size",defaultValue = "3")int size)
    {
        PageHelper.startPage(start,size,"billdate desc");
        PageInfo<WhOutbillH> page = new PageInfo<>(service.queryAll());
        model.addAttribute("page",page);
        return "wh/out/WhOutbillD";
    }

    //跳转材料出库选择页面
    @RequestMapping("updateOutItem")
    public String updateOutItem(Model model,String outBillCode,@RequestParam(defaultValue = "0") String state){
        WhOutbillH list = service.queryItem(outBillCode);
        model.addAttribute("Item",list);
        String id = list.getWhOutbillD().getOutbillcode();
        model.addAttribute("ItemSelect",service.queryOutItem(outBillCode));
        model.addAttribute("Ware",service.queryWareName(list.getWareCode()));
        model.addAttribute("state",state);
        return "wh/out/WhOutbillUpdate";
    }

    //修改材料
    @RequestMapping("updateItem")
    public String updateItem(WhOutbillH whOutbillH, Model model){
        if(whOutbillH != null){
            service.updateItem(whOutbillH);
        }
        //+whOutbillH.getWhOutbillD().getStorebill()
        return "forward:/outH/Index";
    }

    @RequestMapping("Storage")
    public String Storage(String id,String outbillcode){
        System.out.println(outbillcode);
        return "forward:/Storage/queryAll?id="+id+"&outbillcode="+outbillcode;
    }

    //跳新增页面
    @RequestMapping("/Insert")
    public String  Insert(Model model){
        List<BsWarehouse> warehouse = iWhStorageService.queryWare();
        List<BsServeH> list = bsServeService.listBsServe(null);
        model.addAttribute("ware",warehouse);
        model.addAttribute("list",list);
        return "wh/out/InsertWhOutBillH";
    }
    //新增
    @RequestMapping("/InsertOutItem")
    public String InsertOutItem(WhOutbillH whOutbillh){
        whOutbillh.setOutbillcode(contextLoads());
        System.out.println("==============="+whOutbillh);
        int i = service.insertWhOutbillH(whOutbillh);
        return "forward:/outH/Index";
    }

    public String contextLoads() {
        String code = service.getWhOutbillHMaxId();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-DD");
        String id = "CKD"+format.format(new Date());
        Integer i = Integer.parseInt(code);
        i += 1;
        code = id.substring(0,13);
        String number="0000"+i;
        number=number.substring(number.length()-4,number.length());
        code = code.replaceAll("-","");
        code = code + number;
        return code;
    }

    //修改计划
    @RequestMapping("updateItem/{num}/{id}/{outbillcode}")
    public String updateItem(@PathVariable String num,@PathVariable String id,@PathVariable String outbillcode){
        if(num != null && !"".equals(num) && id != null && !"".equals(id)){
            String[] plannum = num.split(",");//出库的数量
            String[] code = id.split(",");//批次库存主键
            WhOutbillD whOutbillD = new WhOutbillD();
            whOutbillD.setOutbillcode(outbillcode);
            service.ItemOutHandle(whOutbillD,plannum,code);
        }
        return "forward:/outH/Index";
    }

    //审核
    @RequestMapping("Audit")
    public String Audit(String code/*出库单号*/,String id/*批次库存主键*/){
        if(!service.checkItem("",code,id)){
            service.updateOutBillhState("0",code);
        }
        return "forward:/outH/Index";
    }

    //反审核
    @RequestMapping("AuditNo")
    public String AuditNo(String code/*出库单号*/,String id/*批次库存主键*/){
        service.ReturnItem(code,id);
        return "forward:/outH/Index";
    }

    //删除
    @RequestMapping("DelPlanNum")
    @ResponseBody
    public int DelPlanNum(String storeBill,String outbillcode){
        boolean flg = service.DelItem(storeBill,outbillcode);
        if(flg){
            return 1;
        }
        return 0;
    }
}
