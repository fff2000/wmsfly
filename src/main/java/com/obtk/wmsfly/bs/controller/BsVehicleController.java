package com.obtk.wmsfly.bs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.service.BsTranunitService;
import com.obtk.wmsfly.bs.service.BsVehicleService;
import com.obtk.wmsfly.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/V")
public class BsVehicleController {

    @Autowired
    BsVehicleService BS;

    @Autowired
    BsTranunitService tranunitService;
    //查询
    @RequestMapping(value= "/list")
    public ModelAndView list(HttpServletRequest request,
                             @RequestParam(value = "start", defaultValue = "0") int start,
                             @RequestParam(value = "size", defaultValue = "3") int size) {

        String context=request.getParameter("context");
        // 将查询的数据以分页的形式展示
        PageHelper.startPage(start, size, "vehicleid desc");// 还可以指定排序规则
        List<BsVehicle> bbs = BS.getVehicleAll(context);//空代表查询所有
        PageInfo<BsVehicle> page = new PageInfo<>(bbs);
        ModelAndView mav = new ModelAndView("/bs/vehicle/vehicleList");//配置返回路径
        mav.addObject("page", page);
        return mav;
    }

   /* *
     * 删除
     * @param ids
     * @return*/

    @RequestMapping("/del/{ids}")
    public String delVehicle(@PathVariable("ids") String ids){
        System.out.println(ids);
        List<String> list = new ArrayList<String>();
        String [] str = ids.split(",");
        for (String item : str){
            list.add(item);
        }
        BS.deleVehicle(list);
        return "redirect:/V/list";
    }

    //跳转到增加页面
    @RequestMapping("/edit")
    public String toAdd(BsVehicle bsVehicle,Model model){
        model.addAttribute("V",bsVehicle);
        List<BsTranunit> tranunitAll = tranunitService.findBsTranunitAll();
        model.addAttribute("tranunit",tranunitAll);
        return "bs/vehicle/vehicleAddUpt";
    }
    //增加
    @RequestMapping("/add")
    public String add(@Valid BsVehicle bsVehicle,BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("V",bsVehicle);
            List<BsTranunit> tranunitAll = tranunitService.findBsTranunitAll();
            model.addAttribute("tranunit",tranunitAll);
            return "bs/vehicle/vehicleAddUpt";
        }
        System.out.println(bsVehicle);
        model.addAttribute("V",bsVehicle);
        String maxId = BS.getVehicleByMaxId();
        bsVehicle.setVehiclecode(addOne(maxId));
        System.out.println(bsVehicle.getVehiclecode());
        BS.addVehicle(bsVehicle);
        return "redirect:/V/list";
    }
    //修改查询
    @RequestMapping("/sel/{id}")
    public String selWarById(Model model,@PathVariable("id") String id,BsVehicle bsVehicle){
        BsVehicle bsVehicle1 = BS.getVehicleById(id);
        System.out.println(bsVehicle1);
        List<BsTranunit> tranunitAll = tranunitService.findBsTranunitAll();
        model.addAttribute("tranunit",tranunitAll);
        model.addAttribute("V",bsVehicle1);
        return "bs/vehicle/vehicleUpdate";
    }
    //修改
    @RequestMapping("/update")
    public String update(Model model,BsVehicle bsVehicle){
        System.out.println(bsVehicle);
         if(BS.updatebsVehicle(bsVehicle)>0){
             System.out.println("成功");
         }else{
             System.out.println("失败");
         }
        return "redirect:/V/list";
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