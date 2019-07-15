package com.obtk.wmsfly.bs.controller;

import com.obtk.wmsfly.bs.service.ElecInfoService;
import com.obtk.wmsfly.domain.ElecInfo;
import com.obtk.wmsfly.domain.MsgFb;
import com.obtk.wmsfly.domain.UseElecType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 功能说明
 *
 * @author
 * @date 2019-07-03 15:06:26
 */
@Controller
@RequestMapping("/elec")
public class ElecInfoController {

        @Autowired
        ElecInfoService elecInfoService;

    /**
     * 查询
     * @param model
     * @return
     */
    @RequestMapping("/eleclist")
        public String elecList(Model model){
            List<ElecInfo> info = elecInfoService.findElecInfo(null);
            model.addAttribute("list",info);
            return "bs/elecInfo/elecList";
        }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/del/{id}")
        public String del(@PathVariable("id") String id){
            int i = elecInfoService.delElecInfo(id);
            return "redirect:/elec/eleclist";
        }

        @RequestMapping("/add")
        public String add(ElecInfo elecInfo){
            System.out.println(elecInfo);
            elecInfoService.insertElectInfo(elecInfo);
            return "redirect:/elec/eleclist";
        }

        @RequestMapping("/toAdd")
        public String toAdd(ElecInfo elecInfo,Model model){
            List<UseElecType> type = elecInfoService.findUseElecType();
            model.addAttribute("elecType",type);
            model.addAttribute("item",elecInfo);
            return "bs/elecInfo/elecInfoAdd";
        }

        @RequestMapping("/toUpdate/{id}")
        public String toUpdate(@PathVariable("id") String id,Model model){
            List<ElecInfo> info = elecInfoService.findElecInfo(id);
            List<UseElecType> type = elecInfoService.findUseElecType();
            model.addAttribute("elecType",type);
            model.addAttribute("item",info);
            model.addAttribute("id",id);
            return "bs/elecInfo/elecTypeUpdate";
        }
        @RequestMapping("/update")
        public String update(ElecInfo elecInfo){
            return "redirect:/elec/eleclist";
        }
}
