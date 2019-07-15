package com.obtk.wmsfly.bs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.dao.BsNewitemMapper;
import com.obtk.wmsfly.bs.service.BsItemtypeService;
import com.obtk.wmsfly.bs.service.BsNewitemService;
import com.obtk.wmsfly.bs.service.impl.BsItemtypeServiceImpl;
import com.obtk.wmsfly.common.StringUtils;
import com.obtk.wmsfly.common.TreeBuilder;
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
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-21 17:13:17
 */
@Controller
@RequestMapping("/itemtype")
public class BsItemtypeController {

    @Autowired
    BsItemtypeService bsItemtypeService;

    @Autowired
    BsNewitemService bsNewitemService;

    @RequestMapping("/out")
    public String List(){
        return "bs/itemtype/itemtypeOpt";
    }

    /**
     * 查询数据转化为tree结构数据
     * @return
     */
    @GetMapping("/left")
    public ModelAndView getBsitemtypeTree() {
        String str = "";
        List<TreeBuilder.Node> itemtypeTree = bsItemtypeService.getBsItemtypesTree();
        str = new TreeBuilder().buildTree(itemtypeTree);
        str = str.replaceAll("\"children\"","\"nodes\"");
        str= str.replaceAll("\"id\"","\"value\"");
        str = str.replaceAll("\"name\"","\"text\"");
        System.out.println(str);
        ModelAndView view = new ModelAndView("bs/itemtype/itemtypeLeft");
        view.addObject("str",str);
        return view;
    }

    /**
     * 查询选择菜单的子集菜单
     * @return
     */
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model,
                       @RequestParam(value = "start", defaultValue = "1") int start,
                       @RequestParam(value = "size", defaultValue = "5") int size){
        String upcode = "";
        upcode = request.getParameter("upcode");
        if(upcode == null){
            upcode = "00";
        }
        BsItemtype bsItemtype = new BsItemtype();
        bsItemtype.setUpcode(upcode);
        PageHelper.startPage(start,size,"upcode,itemtypeCode");
        List<BsItemtype> list = bsItemtypeService.getBsItemtypeByupcode(bsItemtype);
        System.out.println(list);
        PageInfo<BsItemtype> page = new PageInfo<>(list);
        model.addAttribute("page",page);
        model.addAttribute("upcode",upcode);
        return "bs/itemtype/itemtypeList";
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/del/{ids}")
    @ResponseBody
    public String del(@PathVariable("ids")String ids,Model model){
        List<String> list = new ArrayList<String>();
//        String [] str = ids.split(",");
//        for (String item : str){
//            list.add(item);
//        }
        String str = "";
        String count = bsItemtypeService.getBsItemtypeBy(ids);
        System.out.println("count ===== " + count);
        if( count != null && !("0").equals(count)){
            str = "存在子节点,无法删除!";
            return str;
        }
        int i = bsItemtypeService.delBsItemtypeById(ids);
        if(i == 0){
            str ="已启用,无法删除!";
            return str;
        }
        return str ;
    }

    /**
     * 跳转增加页面
     * @param upcode
     * @param model
     * @return
     */
    @GetMapping("/toAdd/{upcode}")
    public String toAdd(@PathVariable("upcode") String upcode,Model model,BsItemtype bsItemtype){
        model.addAttribute("upcode",upcode);
        model.addAttribute("item",bsItemtype);
        System.out.println(upcode);
        return "bs/itemtype/itemtypeAddUpt";
    }

    /**
     * 增加
     * @param bsItemtype
     * @return
     */
    @RequestMapping("/add")
    public ModelAndView addItemtype(@Valid BsItemtype bsItemtype, BindingResult result){
        String upcode = bsItemtype.getUpcode();
       if(result.hasErrors()){
           ModelAndView model = new ModelAndView("bs/itemtype/itemtypeAddUpt");
            model.addObject("item",bsItemtype);
            model.addObject("upcode",bsItemtype.getUpcode());
            return model;
       }
        System.out.println( "upcode ========="+upcode);
        if(upcode.equals("null")){
            bsItemtype.setUpcode("00");
        }
        int id = Integer.valueOf(bsItemtypeService.getBsItemtypeMaxId());
        id += 1;
        String str = "";
        if(id < 10){
            str = "0";
        }
        bsItemtype.setItemtypecode(String.valueOf(str+id));
        System.out.println(bsItemtype);
        int i = 0;
        i = bsItemtypeService.addBsItemtype(bsItemtype);
        ModelAndView model = new ModelAndView(new MappingJackson2JsonView());
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
    public String toUpdate(@PathVariable("id")String id,Model model,BsItemtype bsItemtype){
        bsItemtype = bsItemtypeService.getBsItemtypeById(id);
        System.out.println(bsItemtype);
        model.addAttribute("item",bsItemtype);
        return "bs/itemtype/itemtypeUpdateUpt";
    }
    /**
     * 修改
     * @param bsItemtype
     * @return
     */
    @RequestMapping("/update")
    public ModelAndView  update(@Valid BsItemtype bsItemtype, BindingResult result) {
        System.out.println(bsItemtype);
        if(result.hasErrors()){
            ModelAndView m = new ModelAndView("bs/itemtype/itemtypeUpdateUpt");
            m.addObject("item",bsItemtype);
            return m;
        }
        ModelAndView mav = new ModelAndView(new MappingJackson2JsonView());
        String state = bsItemtype.getState();
        System.out.println(state);
        if("0".equals(state)){
            List<BsNewitem> newitemList = bsNewitemService.findBsNewitemList(bsItemtype.getItemtypecode());
            System.out.println("=========="+ newitemList);
            if(newitemList != null){
                mav.addObject("msg","已经存在基本材料,无法停用！");
                return mav;
            }
        }
        int i = bsItemtypeService.updateBsItemtype(bsItemtype);
        mav.addObject(i);
        return mav;
    }

    //主键自增
    public static String addOne(String testStr){
        String[] strs = testStr.split("[^0-9]");//根据不是数字的字符拆分字符串
        String numStr = strs[strs.length-1];//取出最后一组数字
        if(numStr != null && numStr.length()>0){//如果最后一组没有数字(也就是不以数字结尾)，抛NumberFormatException异常
            int n = numStr.length();//取出字符串的长度
            int num = Integer.parseInt(numStr)+1;//将该数字加一
            String added = String.valueOf(num);
            n = Math.min(n, added.length());
            //拼接字符串
            return testStr.subSequence(0, testStr.length()-n)+added;
        }else{
            throw new NumberFormatException();
        }
    }

}
