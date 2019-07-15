package com.obtk.wmsfly.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @Description 常用工具类
 * @author fly
 * @date 2019-05-10 11:27:10
 */
public class StringUtils {
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