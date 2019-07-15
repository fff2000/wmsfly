package com.obtk.wmsfly.bs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.service.BsServeService;
import com.obtk.wmsfly.common.StringUtilsDiy;
import com.obtk.wmsfly.domain.BsServeH;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-26 13:22:24
 */
@Controller
@RequestMapping("/serve")
public class BsServeController {

    @Autowired
    BsServeService  bsServeService;

    @RequestMapping("/list")
    public String list(HttpServletRequest request,Model model,
                       @RequestParam(value = "start", defaultValue = "1")int start,
                       @RequestParam(value = "size",defaultValue = "2")int size ){
        String content = "";
        content = request.getParameter("content");
        PageHelper.startPage(start,size,"serveCode desc");
        List<BsServeH> list = bsServeService.listBsServe(content);
        System.out.println(list);
        PageInfo<BsServeH>  page = new PageInfo<>(list);
        model.addAttribute("content",content);
        model.addAttribute("page",page);
        return "bs/serve/serveList";
    }

    @RequestMapping("/toAdd")
    public String toAdd(BsServeH bsServeH,Model model){
        model.addAttribute("serve",bsServeH);
        return "bs/serve/serveAddUpt";
    }

    @RequestMapping("/add")
    public String add(@Valid BsServeH bsServeH, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("serve",bsServeH);
            return "bs/serve/serveAddUpt";
        }
        String id = bsServeService.getBsServeMaxId();
        bsServeH.setServecode(addOne(id));
        System.out.println(id);
        bsServeService.insertBsServe(bsServeH);
        return "redirect:/serve/list";
    }
    @RequestMapping("/toUpdate/{id}")
    public String toUpdate(@PathVariable("id") String id,BsServeH bsServeH,Model model){
        bsServeH = bsServeService.getBsServeById(id);
        model.addAttribute("serve",bsServeH);
        return "bs/serve/serveUpdate";
    }


    @RequestMapping("/update")
    public String upadte(@Valid BsServeH bsServeH,BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("serve",bsServeH);
            return "bs/serve/serveUpdate";
        }
        bsServeService.updateBsServe(bsServeH);
        return "redirect:/serve/list";
    }

    @RequestMapping("/del/{ids}")
    @ResponseBody
    public int del(@PathVariable("ids") String id,Model model){
        String str = "";
        StringUtilsDiy utils = new StringUtilsDiy();
        str = utils.subCommaStr(id);
        int i = bsServeService.delBsServe(str);
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
