package com.ujiuye.prometion.utils;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String timeStr) {//timeStr代表前台传过来的字符串
        String partten="yyyy/MM/dd";

        if(timeStr.contains("-")){
            partten="yyyy-MM-dd";
        }
        if(timeStr.contains(":")){
            partten+=" HH:mm:ss";
        }
        SimpleDateFormat format=new SimpleDateFormat(partten);
        Date date = null;
        try {
            date = format.parse(timeStr);
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }
}
