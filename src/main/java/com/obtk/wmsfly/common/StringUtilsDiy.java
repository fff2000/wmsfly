package com.obtk.wmsfly.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description 常用工具类
 * @author fly
 * @date 2019-05-10 11:27:10
 */
public class StringUtilsDiy {
    //获取当前日期
    public String GetNowDate(){
        String temp_str="";
        Date dt = new Date();
        //HH表示24小时制    如果换成hh表示12小时制
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        temp_str=sdf.format(dt);
        return temp_str;
    }
    //获取UUID
    public String getUUID(){
        String uuid = "";
        uuid = UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }

/*    public String  subCommaStr(String idStr){
        String ids = "";
        if(idStr.contains(",")){
            //去掉尾部逗号
            int idx  = idStr.lastIndexOf(",");
            if(idx != -1){
                idStr =  idStr.substring(0,idx);//通过截取逗号前的字符串
            }
            String[] split = (idStr.replaceAll("，", ",")).split(",");
            ids = "'"+StringUtils.join(split, "','")+"'";
        }else{
            ids = "'"+idStr+"'";
        }
        return ids;
    }*/
    /**
     * 删除首尾部逗号，并给字符串加上单引号
     * @param {String}@idStr：要处理的字符串如“,001，002，003，"
     * @return {String}返回结果如“'001'，'002'，'003'"
     * */
    public String  subCommaStr(String idStr){
        String str2 = "",str3 = "";//str2 :处理中字符  str3 处理结果
        String[] strArray = null;
        strArray = idStr.split(","); //拆分字符为"," ,然后把结果交给数组strArray
        for(int i = 0;i< strArray.length;i++){
            str2 = strArray[i];
            if(str2 != null && str2.length() != 0){
                if(strArray.length != i+1) {  //判断是否是最后一位数组，最后一位数组不用最后不用加逗号。
                    str3 += "'" + str2 + "',";
                }else{
                    str3 += "'" + str2 + "'";
                }
            }
        }
       return str3;
    }
}