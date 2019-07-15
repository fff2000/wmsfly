package com.obtk.wmsfly.bs.controller;

/**
 * 功能说明
 * @author fly
 * @date 2019-04-29 21:52:01
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.bs.service.BsBreadService;
import com.obtk.wmsfly.common.StringUtilsDiy;
import com.obtk.wmsfly.domain.BsBread;
import com.obtk.wmsfly.domain.MsgFb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BsBreadController {
    //依赖注
    @Autowired
    BsBreadService breadService;

    @RequestMapping(value= "bs/bread/list")
    public ModelAndView list(HttpServletRequest request,
                             @RequestParam(value = "start", defaultValue = "0") int start,
                             @RequestParam(value = "size", defaultValue = "2") int size) {
        System.out.println("1111");
        String context=request.getParameter("context");
        //查询条件转换为对象
        System.out.println("content======"+context);
        BsBread query = new BsBread();
        String title = "";
        title = (String)request.getParameter("title");//如果request有值则获取查询条件
        query.setTitle(title);
        // 将查询的数据以分页的形式展示
        PageHelper.startPage(start, size, "breadCode desc");// 还可以指定排序规则
        List<BsBread> bbs=null;
        if(("已启用").equals(context)){
            context="1";
            bbs=breadService.findBystate(context);
            System.out.println("222");
        }else if (("未启用").equals(context)){
            context="0";
            bbs=breadService.findBystate(context);
            System.out.println("33");
        }else{
            bbs = breadService.findByAll(context);//空代表查询所有
            System.out.println("44");
        }
        PageInfo<BsBread> page = new PageInfo<>(bbs);
        System.out.println("55");
        System.out.println(bbs+"bbs");
        System.out.println(page+"page");
        ModelAndView mav = new ModelAndView("/bs/bread/breadList.html");//配置返回路径
        mav.addObject("page", page);
        return mav;
    }

    //通过主键删除记录
    @RequestMapping(value = "/list/del")
    @ResponseBody
    public MsgFb delete(@RequestParam(value = "idStr") String id, HttpServletRequest request) {
        System.out.println("要删除的id为："+id);
        MsgFb msg = new MsgFb();
      /*  String ids = "";
        StringUtilsDiy utils = new StringUtilsDiy();
        ids = utils.subCommaStr(idStr);*/// //去掉首尾部逗号，每个字符串加上单引号
        int delNum = breadService.deleteById(id); //通过主键删除记录，返回删除条数
        System.out.println("删除ID" + id + "删除记录数：" + delNum);
        msg.setCode(delNum > 0 ? true : false); //删除记录数大于一条记录，代表删除成功。
        msg.setMsg(delNum > 0 ? "删除成功！" : "已启动,无法删除！");
        return msg;
    }

    //新增修改跳转页面
    @RequestMapping(value = "/addUptUrl")
    @ResponseBody
    public ModelAndView addUptUrl(@RequestParam(value = "pid") String breadcode, HttpServletRequest request) {
        System.out.println("addUptUrl2");
        BsBread bs = new BsBread();
        //如果主键有值，根据主键查询详情，bbreadCode.length()>1用get方式提交可能包含逗号，所以包含逗号的不代表有主键。
        if (null != breadcode && !breadcode.equals("") && breadcode.length() > 0) {
            bs = breadService.findById(breadcode);
        }
        System.out.println("addUptUrl3");
        ModelAndView mavs = new ModelAndView("bs/bread/breadAddUpt");
        mavs.addObject("bs", bs);
        System.out.println("addUptUrl4");
        return mavs;
    }


    //新增修改保存对象
    @RequestMapping(value = "bread/addUptSave")
    @ResponseBody
    public MsgFb addUptSave(BsBread bsBread, HttpServletRequest request, Model model) {
        System.out.println(bsBread);
        Boolean isInsert = false;
        MsgFb msg = new MsgFb();
        //修改记录
        if (null != bsBread.getBreadcode() && ! bsBread.getBreadcode().equals("")) {
            System.out.println("addUptSave1");
            isInsert = breadService.updateById(bsBread);
            msg.setCode(isInsert);
            //新增记录
        } else {
            String maxId = breadService.getBsbreadMaxId();
            bsBread.setBreadcode(addOne(maxId));
            System.out.println("品牌Id"+ bsBread.getBreadcode());
            isInsert = breadService.insertBs(bsBread);
            msg.setCode(isInsert);
            model.addAttribute("bs", bsBread);
        }
        System.out.println("addUptSave2");
        return msg;
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