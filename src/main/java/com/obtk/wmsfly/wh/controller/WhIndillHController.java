package com.obtk.wmsfly.wh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.service.*;
import com.obtk.wmsfly.common.StringUtils;
import com.obtk.wmsfly.domain.*;
import com.obtk.wmsfly.wh.dao.WhStorageDMapper;
import com.obtk.wmsfly.wh.service.WhInbillDService;
import com.obtk.wmsfly.wh.service.WhIndillHService;
import com.obtk.wmsfly.wh.service.WhStorageDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-29 15:50:39
 */
@Controller
@RequestMapping("/indillh")
public class WhIndillHController {

    //仓库
    @Autowired
    BsWarehouseService bsWarehouseService;
    @Autowired
    WhIndillHService whIndillHService;
    //承运商
    @Autowired
    BsTranunitService bsTranunitService;
    //供应商
    @Autowired
    BsServeService bsServeService;
    //车辆
    @Autowired
    BsVehicleService bsVehicleService;
    //材料信息
    @Autowired
    BsNewitemService bsNewitemService;
    //品牌信息
    @Autowired
    BsBreadService bsBreadService;
    //入库材料信息
    @Autowired
    WhInbillDService whInbillDService;
    //库存材料明细表
    @Autowired
    WhStorageDService whStorageDMapper;


    @RequestMapping("/list")
    public String list(Model model,HttpServletRequest request,
                       @RequestParam(value = "start", defaultValue = "1") int start,
                       @RequestParam(value = "size", defaultValue = "4") int size) {
        String result = request.getParameter("result");
        PageHelper.startPage(start, size,"a.inbillCode desc");
        List<WhInbillD> inbillD = whInbillDService.getWhInbillD(result);
        PageInfo<WhInbillD> page = new PageInfo<>(inbillD);
        model.addAttribute("result",result);
        model.addAttribute("page", page);
        return "wh/inbill/inbilhList";
    }

    @RequestMapping("/toAdd")
    public String toAdd(WhInbillH whInbillH, Model model) {
        //查询仓库
        List<BsWarehouse> warehouseAll = bsWarehouseService.getWarehouseAll(null);
        //查询承运商
        List<BsTranunit> tranunitAll = bsTranunitService.findBsTranunitAll();
        //查询供应商
        List<BsServeH> serveHS = bsServeService.listBsServe(null);
        //查询车辆
        List<BsVehicle> vehicleAll = bsVehicleService.getVehicleAll(null);
        model.addAttribute("ware", warehouseAll);
        model.addAttribute("tranunit", tranunitAll);
        model.addAttribute("serve", serveHS);
        model.addAttribute("vehilce", vehicleAll);
        model.addAttribute("indill", whInbillH);
        return "wh/inbill/indillhAdd";
    }

    @RequestMapping("/add")
    @ResponseBody
    public MsgFb add(@Valid WhInbillH whInbillH, BindingResult result) throws ParseException {
        String maxId = "";
        MsgFb msg = new MsgFb();
        if (result.hasErrors()) {
            msg.setMsg("error");
            return msg;
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        StringUtils utils = new StringUtils();
        System.out.println("制单时间"+df.parse(utils.GetNowDate()));
        maxId = whIndillHService.getWhIndillHMaxId();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        String batchno = format.format(new Date());
        System.out.println(whInbillH);
        whInbillH.setInbillcode(batchno + StringUtils.addOne(maxId));
        System.out.println(whInbillH.getInbillcode());
        //审核
        whInbillH.setState("0");
        //装订号
        whInbillH.setBindcode(batchno + StringUtils.addOne(maxId));
        //制单时间
        whInbillH.setBilldate(df.parse(utils.GetNowDate()));
        int i = whIndillHService.insertWhIndillH(whInbillH);
        if (i > 0) {
            msg.setMsg(whInbillH.getInbillcode());
        }
        return msg;
    }

    //跳转材料增加页面
    @RequestMapping("/toAddItem")
    public String toAddItem(HttpServletRequest request, Model model,
                            @RequestParam(value = "start", defaultValue = "1") int start,
                            @RequestParam(value = "size", defaultValue = "3") int size) {
        String id = "";
        String itemname = "";
        id = request.getParameter("id");
        itemname = request.getParameter("itemname");
        List<BsBread> breadName = bsBreadService.getBsbreeadName();
        PageHelper.startPage(start, size);
        //查询材料
        List<BsNewitem> newitemAll = bsNewitemService.getNewitemandtype(itemname);
        PageInfo<BsNewitem> page = new PageInfo<>(newitemAll);
        model.addAttribute("itemname",itemname);
        model.addAttribute("breadName", breadName);
        model.addAttribute("newitem", newitemAll);
        model.addAttribute("id", id);
        model.addAttribute("page", page);
        return "wh/inbill/addItem";

    }
    //添加入库材料
    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    @ResponseBody
    public String addItem(@RequestBody List<WhInbillD> whInbillDS) {
        int i = 0;
        String maxId = "";
        for (WhInbillD wh : whInbillDS) {
            maxId = whInbillDService.getInbillDMaxId(wh.getInbillcode());
            wh.setRowno(StringUtils.addOne(maxId));
            i += whInbillDService.insertInbillD(wh);
            System.out.println(wh);
        }
        if (i > 0) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/state/{id}")
    @ResponseBody
    public String state(@PathVariable("id")String id) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sf1 = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy", Locale.ENGLISH);
        List<WhInbillD> inbillDList = whInbillDService.getWhInbillDList(id);
        WhStorageD whStorageD = new WhStorageD();
        if(!inbillDList.isEmpty()){
            List<WhInbillD> whInbillD = whInbillDService.getWhInbillD(id);
            for (WhInbillD wh : whInbillD){
                String storebill = wh.getWhInbillH().getInbillcode() + wh.getRowno();
                whStorageD.setStorebill(storebill);
                whStorageD.setBreadcode(wh.getBreadcode());
                whStorageD.setItemcode(wh.getItemcode());
                whStorageD.setWarecode(wh.getWhInbillH().getWarecode());
                whStorageD.setItemnum(wh.getItemnum());
                whStorageD.setPlannum(BigDecimal.valueOf(0));
                whStorageD.setIndate(simpleDateFormat.format(sf1.parse(String.valueOf(wh.getWhInbillH().getIndate()))));
                whStorageDMapper.insertWhStorageD(whStorageD);
            }
             whIndillHService.updateInbillHState(id);
            return "success";
        }
        return "入库单下不存在货物";
    }
    //反审核
    @RequestMapping("/reverse/{id}")
    @ResponseBody
    public String ReverseState(@PathVariable("id")String id){
        WhInbillH inbillHState = whIndillHService.getInbillHState(id);
        if(inbillHState == null){
            int state = whIndillHService.getWhoutbilhState(id);
            if(state > 0){
                return "已有材料出库,无法反审核！";
            }
            int h = whStorageDMapper.delWhStorageD(id);
            if(h > 0){
                int i = whIndillHService.updateInbillHreverseState(id);
                if(i > 0){
                    return "success";
                }
                return "反审核失败！";
            }
        }
        return "fail";
    }

    //删除主表数据
    @RequestMapping("/del/{id}")
    @ResponseBody
    public String del(@PathVariable("id")String id){
        List<WhInbillD> inbillDList = whInbillDService.getWhInbillDList(id);
        if(inbillDList.isEmpty()){
            int i = whIndillHService.delInbillH(id);
            if(i > 0){
                return "success";
            }
            return "已经审核,无法删除！";
        }
        return "存在货物信息,不允许删除！";
    }

    //跳转修改页面
    @RequestMapping("/toUpdate")
    public String toUpdate(HttpServletRequest request,WhInbillH whInbillH,Model model,
                           @RequestParam(value = "start", defaultValue = "1") int start,
                           @RequestParam(value = "size", defaultValue = "2") int size){
        String id = request.getParameter("id");
        String type = request.getParameter("type");
        System.out.println(id);
        PageHelper.startPage(start, size);
        //查询仓库
        List<BsWarehouse> warehouseAll = bsWarehouseService.getWarehouseAll(null);
        //查询承运商
        List<BsTranunit> tranunitAll = bsTranunitService.findBsTranunitAll();
        //查询供应商
        List<BsServeH> serveHS = bsServeService.listBsServe(null);
        //查询车辆
        List<BsVehicle> vehicleAll = bsVehicleService.getVehicleAll(null);
        //查询主表
        WhInbillH inbillHById = whIndillHService.getWhInbillHById(id);
        //查询入库材料明细表
        List<WhInbillD> inbillDById = whInbillDService.getWhInbillDById(id);
        PageInfo<WhInbillD> page = new PageInfo<>(inbillDById);
        model.addAttribute("id",id);
        model.addAttribute("inbillH",inbillHById);
        model.addAttribute("ware", warehouseAll);
        model.addAttribute("tranunit", tranunitAll);
        model.addAttribute("serve", serveHS);
        model.addAttribute("vehilce", vehicleAll);
        model.addAttribute("page",page);
        if("query".equals(type)){
            return "wh/inbill/queryIndillh";
        }
        return "wh/inbill/indillhUpdate";
    }

    @RequestMapping("/updateInbillH")
    public String updateInbillH(WhInbillH whInbillH){
        System.out.println(whInbillH);
        int i = whIndillHService.updateInbillH(whInbillH);
        if(i > 0){
            return "redirect:/indillh/list";
        }
        return "redirect:/indillh/toUpdate?id="+whInbillH.getInbillcode();
    }
    


    //车辆信息的数据回显
    @RequestMapping("/vehicle/{id}")
    @ResponseBody
    public BsVehicle getVehicle(@PathVariable("id") String id) {
        List<BsVehicle> vehicleAll = bsVehicleService.getVehicleAll(id);
        BsVehicle vehicle = new BsVehicle();
        for (BsVehicle v : vehicleAll) {
            vehicle.setDriver(v.getDriver());
            vehicle.setDriverid(v.getDriverid());
        }
        return vehicle;
    }
}
