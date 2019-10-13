package com.cqc.test.mongodb.common;

import org.springframework.core.convert.converter.Converter;

import java.sql.Date;

/**
 * @Author: chenqianchong
 * @Date: 2019/10/13 16:08
 */
public class DateConverter implements Converter<java.util.Date,java.sql.Date> {

    @Override
    public Date convert(java.util.Date date) {
        if(date !=null ){
            return new Date(date.getTime());
        }
        return null;
    }
}
