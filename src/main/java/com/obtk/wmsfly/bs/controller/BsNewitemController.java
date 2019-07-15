package com.obtk.wmsfly.bs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.dao.BsItemtypeMapper;
import com.obtk.wmsfly.bs.dao.BsNewitemMapper;
import com.obtk.wmsfly.bs.service.BsBreadService;
import com.obtk.wmsfly.bs.service.BsItemtypeService;
import com.obtk.wmsfly.bs.service.BsNewitemService;
import com.obtk.wmsfly.bs.service.impl.BsItemtypeServiceImpl;
import com.obtk.wmsfly.common.TreeBuilder;
import com.obtk.wmsfly.domain.BsBread;
import com.obtk.wmsfly.domain.BsItemtype;
import com.obtk.wmsfly.domain.BsNewitem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-25 15:16:42
 */
@Controller
@RequestMapping("/newitem")
public class BsNewitemController {

    @Autowired
    BsItemtypeService bsItemtypeService;

    @Autowired
    BsNewitemService bsNewitemService;

    @Autowired
    BsBreadService bsBreadService;

    @RequestMapping("/out")
    public String out() {
        return "bs/newitem/newitemOpt";
    }

    @GetMapping("/left")
    public String getBsitemtypeTree(Model model) {
        String str = "";
        List<TreeBuilder.Node> itemtypeTree = bsItemtypeService.getBsItemtypesTree();
        str = new TreeBuilder().buildTree(itemtypeTree);
        str = str.replaceAll("\"children\"", "\"nodes\"");
        str = str.replaceAll("\"id\"", "\"value\"");
        str = str.replaceAll("\"name\"", "\"text\"");
        System.out.println(str);
        model.addAttribute("str", str);
        return "bs/newitem/newitemLeft";
    }

    /**
     * 根据菜单查询材料基本信息
     * @param request
     * @param model
     * @param start
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model,
                       @RequestParam(value = "start", defaultValue = "1") int start,
                       @RequestParam(value = "size", defaultValue = "5") int size) {
        String upcode = "";
        upcode = request.getParameter("upcode");
        System.out.println("tree的Id ===========" + upcode);
        PageHelper.startPage(start, size, "itemcode desc");
        List<BsNewitem> newitemList = bsNewitemService.findBsNewitemList(upcode);
        PageInfo<BsNewitem> page = new PageInfo<>(newitemList);
        model.addAttribute("page", page);
        model.addAttribute("upcode",upcode);
        return "bs/newitem/newitemList";
    }

    /**
     * 跳转增加页面
     * @param upcode
     * @param bsNewitem
     * @return
     */
    @GetMapping("/toadd/{upcode}")
    public ModelAndView toadd(@PathVariable("upcode")String upcode,BsNewitem bsNewitem){
        System.out.println("upcode ====="+upcode);
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        if(("null").equals(upcode)){
            model.addObject("str","请选择材料进行添加！");
            System.out.println(model.toString());
        }
        return model;
    }

    @GetMapping("/judgeAdd/{upcode}")
    public ModelAndView judgeAdd(@PathVariable("upcode")String upcode){
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        BsItemtype itemtype = bsItemtypeService.getItemtypeBystate(upcode);
        if(itemtype == null){
            model.addObject("msg","请先启用该材料！");
        }
        return model;

    }

    @GetMapping("/toAdd/{upcode}")
    public ModelAndView toAdd(@PathVariable("upcode")String upcode,BsNewitem bsNewitem){
        System.out.println("Add upcode ====="+upcode);
        List<BsBread> bsBreads = findBreadInfo();
        ModelAndView view = new ModelAndView("bs/newitem/newitemAddUpt");
        view.addObject("msg","1111111111");
        view.addObject("upcode",upcode);
        view.addObject("bread",bsBreads);
        view.addObject("item",bsNewitem);
        return view;
    }
    /**
     * 增加页面
     * @param request
     * @param bsNewitem
     * @param result
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView add(HttpServletRequest request,@Valid BsNewitem bsNewitem, BindingResult result){
        String upcode = "";
        upcode = request.getParameter("upcode");
        List<BsBread> bsBreads = findBreadInfo();
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("bs/newitem/newitemAddUpt");
            model.addObject("bread",bsBreads);
            model.addObject("item",bsNewitem);
            return model;
        }
        int maxId = Integer.valueOf(bsNewitemService.getBsNewitemMaxId());
        maxId += 1;
        String str = "";
        if(maxId < 10){
            str = "0";
        }
        bsNewitem.setItemcode(String.valueOf(str+maxId));
        bsNewitem.setItemtypecode(upcode);
        System.out.println(bsNewitem);
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        int i = 0;
        i = bsNewitemService.inserBsNewitem(bsNewitem);
        model.addObject(i);
        return model;
    }

    /**
     * 跳转修改页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id,Model model,BsNewitem bsNewitem){
        System.out.println(id);
        bsNewitem = bsNewitemService.getBsNewitemById(id);
        List<BsBread> bsBreads = findBreadInfo();
        model.addAttribute("bread",bsBreads);
        model.addAttribute("item",bsNewitem);
        return "bs/newitem/newitemUpdateUpt";
    }

    /**
     * 修改页面
     * @return
     */
    @RequestMapping("/update")
    public ModelAndView update(@Valid BsNewitem bsNewitem,BindingResult result){
        System.out.println(bsNewitem);
        List<BsBread> bsBreads = findBreadInfo();
        if(result.hasErrors()){
            ModelAndView model = new ModelAndView("bs/newitem/newitemUpdateUpt");
            model.addObject("bread",bsBreads);
            model.addObject("item",bsNewitem);
            return model;
        }
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
        int i = bsNewitemService.updateBsNewitem(bsNewitem);
        model.addObject(i);
        return model;
    }


    @RequestMapping("/del/{id}")
    @ResponseBody
    public String del(@PathVariable("id") String id){
        int i = bsNewitemService.deleBsNewitemById(id);
        String msg = "";
        if(i == 0){
            msg = "已经启用，无法删除！";
        }
        return msg;
    }
    /**
     * 获取品牌信息
     * @return
     */
    public List<BsBread> findBreadInfo(){
        return bsBreadService.getBsbreeadName();
    }
}
