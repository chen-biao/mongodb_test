package com.cqc.test.mongodb.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Author: chenqianchong
 * @Date: 2019/10/13 14:53
 */
@Data
public class Hello {

    private Long id;
    private String name;
    private boolean sex;
    private Date date;


}
