package com.cqc.test.mongodb.dao;

import com.cqc.test.mongodb.entity.Hello;

/**
 * @Author: chenqianchong
 * @Date: 2019/10/13 14:53
 */
public interface HelloDao {

    void add(Hello hello);

    void delete(Hello hello);

    void update(Hello hello);

    Hello find(Hello hello);

}
