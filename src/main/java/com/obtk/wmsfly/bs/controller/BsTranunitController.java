package com.obtk.wmsfly.bs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.service.BsTranunitService;
import com.obtk.wmsfly.common.StringUtilsDiy;
import com.obtk.wmsfly.domain.BsTranunit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-26 17:40:00
 */
@Controller
@RequestMapping("/tranunit")
public class BsTranunitController {

    @Autowired
    BsTranunitService bsTranunitService;

    @RequestMapping("/list")
    public String list(Model model, HttpServletRequest request,
                       @RequestParam(value = "start", defaultValue = "1")int start,
                       @RequestParam(value = "size",defaultValue = "2")int size){
        String content = request.getParameter("content");
        PageHelper.startPage(start,size,"tranCode desc");
        List<BsTranunit> tranunitAll = null;
        if(content != null && content != ""){
            tranunitAll  = bsTranunitService.getBsTranunit(content);
        }else {
        tranunitAll  = bsTranunitService.getBsTranunit(null);
        }
        PageInfo<BsTranunit> page = new PageInfo<>(tranunitAll);
        model.addAttribute("page",page);
        return "bs/tranunit/tranunitList";
    }

    @RequestMapping("/toAdd")
    public String toAdd(BsTranunit bsTranunit,Model model){
        model.addAttribute("tranunit",bsTranunit);
        return  "bs/tranunit/tranunitAddUpt";
    }

    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id")String id, BsTranunit bsTranunit, Model model){
        System.out.println(id);
        bsTranunit = bsTranunitService.getBsTranunitById(id);
        model.addAttribute("tranunit",bsTranunit);
        return "bs/tranunit/tranunitUpdate";
    }

    //修改
    @RequestMapping("/update")
    public String update(@Valid BsTranunit bsTranunit,BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("tranunit",bsTranunit);
            return "bs/tranunit/tranunitUpdate";
        }
        System.out.println(bsTranunit);
        bsTranunitService.updateBsTranunit(bsTranunit);
        return "redirect:/tranunit/list";
    }
    /**
     * 增加
     * @param bsTranunit
     * @param result
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String add(@Valid BsTranunit bsTranunit, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("tranunit",bsTranunit);
            return "bs/tranunit/tranunitAddUpt";
        }
        String maxId = bsTranunitService.getBsTranunitMaxId();
        bsTranunit.setTrancode(addOne(maxId));
        System.out.println(bsTranunit.getTrancode());
        bsTranunitService.insertBsTranunit(bsTranunit);
        return "redirect:/tranunit/list";
    }

    @RequestMapping("/del/{ids}")
    @ResponseBody
    public int del(@PathVariable("ids")String ids,Model model){
        String str = "";
        StringUtilsDiy utils = new StringUtilsDiy();
        str = utils.subCommaStr(ids);
        int i = bsTranunitService.delBsTranunit(str);
        return i;
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
