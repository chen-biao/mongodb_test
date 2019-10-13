package com.cqc.test.mongodb.dao.impl;

import com.cqc.test.mongodb.dao.HelloDao;
import com.cqc.test.mongodb.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.sql.Date;

/**
 * @Author: chenqianchong
 * @Date: 2019/10/13 14:57
 */
@Component
public class HelloDaoImpl implements HelloDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Hello hello) {
        mongoTemplate.save(hello);
    }

    @Override
    public void delete(Hello hello) {
        Criteria where = Criteria.where("name").is(hello.getName());
        Query query = new Query(where);
        mongoTemplate.remove(query, Hello.class);
    }

    @Override
    public void update(Hello hello) {
        Criteria where = Criteria.where("name").is(hello.getName());
        Query query = new Query(where);
        Date date = new Date(System.currentTimeMillis());
        Update update = new Update().set("sex",false).set("date",date);
        mongoTemplate.updateFirst(query,update,Hello.class);
    }

    @Override
    public Hello find(Hello hello) {
        Hello id = mongoTemplate.findOne(new Query(Criteria.where("id").is(hello.getId())), Hello.class);
        return id;
    }
}
