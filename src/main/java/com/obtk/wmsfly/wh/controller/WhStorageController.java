package com.obtk.wmsfly.wh.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.obtk.wmsfly.domain.WhStorage;
import com.obtk.wmsfly.domain.WhStorageD;
import com.obtk.wmsfly.wh.service.IWhStorageService;
import com.obtk.wmsfly.wh.service.WhStorageDService;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/Storage")
public class WhStorageController {

    @Autowired
    private IWhStorageService service;
    @Autowired
    WhStorageDService whStorageDService;
    //查询所有
    @RequestMapping("queryAll")
    public String queryAll(Model model,String id,String outbillcode){
        String[] code = outbillcode.split(",");
        List<WhStorageD> list = service.queryAll(id);
        model.addAttribute("Item",list);
        model.addAttribute("ware",service.queryWare());
        model.addAttribute("outbillcode",code[0]);
        model.addAttribute("ItemName",service.queryItem());
        model.addAttribute("bread",service.queryBread());
        return "wh/out/WhOutStorage";
    }

    //选择材料
    @RequestMapping("updateStorage")
    public String updateStorage(String plannum,String code,String outbillcode){
        String[] array = outbillcode.split(",");
        return "forward:/outH/updateItem/"+plannum+"/"+code+"/"+array[0];
    }

    //查询
    @RequestMapping("/list")
    public String list(HttpServletRequest request, Model model,
                       @RequestParam(value = "start", defaultValue = "1") int start,
                       @RequestParam(value = "size", defaultValue = "2") int size) {
        String context = "";
        context = request.getParameter("context");
        PageHelper.startPage(start, size);
        List<WhStorage> list = service.findAll(context);
        List<WhStorageD> list1 = whStorageDService.findAll();
        System.out.println(list);
        PageInfo<WhStorage> page = new PageInfo<>(list);
        PageInfo<WhStorageD> page1 = new PageInfo<>(list1);
        model.addAttribute("context", context);
        model.addAttribute("page", page);
        model.addAttribute("page1", page1);
        return "wh/storage/List";
    }

    //导出
    @RequestMapping(value = "/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        List<WhStorageD> users = whStorageDService.findAll();

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取excel测试表格");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("入库单列表");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第3个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(rowRegion);

        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("批次库存");//为第一个单元格设值
        row.createCell(1).setCellValue("材料编码");//为第二个单元格设值
        row.createCell(2).setCellValue("品牌编码");//为第三个单元格设值
        row.createCell(3).setCellValue("仓库编码");//为第一个单元格设值
        row.createCell(4).setCellValue("件数");//为第二个单元格设值
        row.createCell(5).setCellValue("库存计划数量");//为第三个单元格设值
        row.createCell(6).setCellValue("库存实际数量");//为第一个单元格设值
        row.createCell(7).setCellValue("数据来源");//为第二个单元格设值
        row.createCell(8).setCellValue("入库日期");//为第三个单元格设值

        for (int i = 0; i < users.size(); i++) {
            row = sheet.createRow(i + 2);
            WhStorageD user = users.get(i);
            row.createCell(0).setCellValue(user.getStorebill());
            row.createCell(1).setCellValue(user.getItemcode());
            row.createCell(2).setCellValue(user.getBreadcode());
            row.createCell(4).setCellValue(user.getWarecode());
            row.createCell(5).setCellValue(user.getUnitcode());
            row.createCell(6).setCellValue(user.getPlannum().toString());
            row.createCell(7).setCellValue(user.getItemnum().toString());
            row.createCell(8).setCellValue(user.getFromTable());
            row.createCell(9).setCellValue(user.getIndate());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        String fileName = "库存.xls";
        response.setHeader("Content-disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }



}
