package com.obtk.wmsfly.sys.controller;

/**
 * @deprecated 公告管理CURD
 *C - Creation 增加
 * R - Retrieve 查询
 * U - Update 修改
 * D - DELETE 删除
 * @author fly
 * @date 2019-04-29 21:52:01
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.common.StringUtilsDiy;
import com.obtk.wmsfly.domain.MsgFb;
import com.obtk.wmsfly.domain.SysBbs;
import com.obtk.wmsfly.sys.service.SysBbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller	//声明这是Controller层
@RequestMapping(value= "/bbs")
public class SysBbsController {
    //依赖注入
    @Autowired
    SysBbsService bbsService;

    @RequestMapping(value= "/list")
    public ModelAndView   list(SysBbs queryBbs,
                               @RequestParam(value = "start",defaultValue = "0")int start,
                               @RequestParam(value = "size",defaultValue = "2")int size ) {
        // 将查询的数据以分页的形式展示
        PageHelper.startPage(start,size,"bbsId desc");// 还可以指定排序规则
        List<SysBbs> bbs = bbsService.findByBbs(queryBbs);//空代表查询所有
        PageInfo<SysBbs> page = new PageInfo<>(bbs);
        //配置返回页面文件路径
        ModelAndView mav = new ModelAndView ("/sys/bbs/bbsList.html");
        mav.addObject("page", page);
        return mav;
    }
    //通过主键删除记录
    @RequestMapping(value="/list/del")
    @ResponseBody
    public MsgFb  delete(@RequestParam(value = "idStr") String idStr, HttpServletRequest request){
        MsgFb msg = new MsgFb();
        String ids = "";
        StringUtilsDiy utils = new StringUtilsDiy();
        ids = utils.subCommaStr(idStr);// //去掉首尾部逗号，每个字符串加上单引号
        int delNum = bbsService.deleteById(ids); //通过主键删除记录，返回删除条数
        System.out.println("删除ID"+idStr+"删除记录数："+delNum);
        msg.setCode(delNum>0?true:false); //删除记录数大于一条记录，代表删除成功。
        msg.setMsg(delNum>0?"删除成功！":"删除失败！");
        return msg;
    }
    //新增修改跳转页面
    @RequestMapping(value= "/addUptUrl")
    @ResponseBody
    public ModelAndView  addUptUrl(@RequestParam(value ="pid") String bbsId ) {
        System.out.println("addUptUrl1");
        SysBbs bbs = new SysBbs();
        //如果主键有值，根据主键查询详情，用get方式提交可能包含逗号，所以包含逗号的不代表有主键。
        if(null !=  bbsId  && !bbsId.equals(""))
            bbs  = bbsService.findById(bbsId);
        ModelAndView mavs = new ModelAndView("/sys/bbs/bbsAddUpt");
        mavs.addObject("bbs", bbs);
        System.out.println("addUptUrl1");
        return mavs;
    }

    //新增修改保存对象
    @RequestMapping(value = "/addUptSave")
    @ResponseBody
    public MsgFb addUptSave(SysBbs sysBbs, HttpServletRequest request, Model model) {
        String bbsId = "";
        //bbsId有值 代表修改记录否则新增记录
        bbsId = sysBbs.getBbsId().length() > 0 ? sysBbs.getBbsId() : "";
        Boolean isInsert = false;
        StringUtilsDiy strUtil = new StringUtilsDiy();
        MsgFb msg = new MsgFb();
        sysBbs.setPublicDate(strUtil.GetNowDate());
        //修改记录
        if (null != bbsId && !bbsId.equals("")) {
            System.out.println("addUptSave1");
            isInsert = bbsService.updateById(sysBbs);
            msg.setCode(isInsert);
            //新增记录
        } else {
            sysBbs.setBbsId(strUtil.getUUID());
            //获取当前登录用户名称。
            sysBbs.setBillMan((String) request.getSession().getAttribute("username"));
            //制单日期获取当前系统日期
            sysBbs.setBillDate(strUtil.GetNowDate());
            System.out.println("查看公告管理插入结果" + sysBbs.getTitle());
            isInsert = bbsService.insertBbs(sysBbs);
            msg.setCode(isInsert);

            model.addAttribute("bbs", sysBbs);
        }
        System.out.println("addUptSave2");
        return msg;
    }

}