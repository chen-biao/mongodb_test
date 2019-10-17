package com.cqc.test.mongodb.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: chenqianchong
 * @Date: 2019/10/16 21:07
 */
@Data
public class AddressBook {
    private Long userId;
    private List<PasreAndRaw> lists;

}
