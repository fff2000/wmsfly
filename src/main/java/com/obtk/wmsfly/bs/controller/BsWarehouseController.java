package com.obtk.wmsfly.bs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.service.BsWarehouseService;
import com.obtk.wmsfly.domain.BsWarehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-05-14 14:41:31
 */
@Controller
@RequestMapping("/war")
public class BsWarehouseController {

    @Autowired
    BsWarehouseService bsWarehouseService;

    /**
     * 查询
     */
    @RequestMapping("/list")
    public String WarehouseListInfo(HttpServletRequest request,
                                    @RequestParam(value = "start", defaultValue = "1")int start,
                                    @RequestParam(value = "size",defaultValue = "5")int size,Model model ){
        // 将查询的数据以分页的形式展示

        String content=request.getParameter("content");
        //查询条件转换为对象
        System.out.println("content======"+content);
        PageHelper.startPage(start,size,"warecode desc");// 还可以指定排序规则
        List<BsWarehouse> list = null;
        if(content != null && content != ""){
            content.trim();
            list = bsWarehouseService.getWarehouseAll(content);//空代表查询所有
        }else {
           list = bsWarehouseService.getWarehouseAll(null);//空代表查询所有
        }
        System.out.println(list);
        PageInfo<BsWarehouse> page = new PageInfo<>(list);
        System.out.println(page.getPages());
        //配置返回页面文件路径
        model.addAttribute("content",content);
        model.addAttribute("page",page);
        return "bs/ware/warehouseList";
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/del/{ids}")
    public String delWarehouse(@PathVariable("ids") String ids){
        System.out.println(ids);
   /*     String str = "";
        StringUtilsDiy utils = new StringUtilsDiy();+
        str = utils.subCommaStr(ids);
        System.out.println(str);*/
         List<String> list = new ArrayList<String>();
        String [] str = ids.split(",");
        for (String item : str){
            list.add(item);
        }
        bsWarehouseService.deleWarehouse(list);
        return "redirect:/war/list";
    }

    //跳转到增加页面
    @RequestMapping("/edit")
    public String toAdd(BsWarehouse bsWarehouse,Model model){
        model.addAttribute("war",bsWarehouse);
        return "bs/ware/warAddUpt";
    }

    //增加
    @RequestMapping("/add")
    public String add(@Valid BsWarehouse bsWarehouse, BindingResult result,Model model){
        if(result.hasErrors()){
            model.addAttribute("war",bsWarehouse);
            return "bs/ware/warAddUpt";
        }
        int id = Integer.parseInt(bsWarehouseService.getWarehouseByMaxId());
        id = id + 1;
        String str = "";
        if(id < 10){
            str = "0";
        }
        bsWarehouse.setWarecode(String.valueOf(str+id));
        System.out.println(bsWarehouse);
        bsWarehouseService.addWarehouse(bsWarehouse);
        return "redirect:/war/list";
    }

    //修改查询
    @RequestMapping("/sel/{id}")
    public String selWarById(Model model,@PathVariable("id") String id,BsWarehouse bsWarehouse){
        BsWarehouse warehouse = bsWarehouseService.getWarehouseById(id);
        System.out.println(warehouse);
        model.addAttribute("war",warehouse);
        return "bs/ware/warUpdate";
    }
    //修改
    @RequestMapping("/update")
    public String update(Model model,@Valid BsWarehouse bsWarehouse,BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("war",bsWarehouse);
            return "bs/ware/warUpdate";
        }
        bsWarehouseService.updateWarehouse(bsWarehouse);
        return "redirect:/war/list";
    }

}
