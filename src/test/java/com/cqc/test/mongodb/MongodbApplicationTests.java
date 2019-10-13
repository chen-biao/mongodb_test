package com.cqc.test.mongodb;

import com.cqc.test.mongodb.dao.HelloDao;
import com.cqc.test.mongodb.entity.Hello;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongodbApplicationTests {

    @Autowired
    private HelloDao helloDao;

    @Test
    public void contextLoads() {
        Random random = new Random();
        List<Hello> hellos = new ArrayList<>();
        for(int i = 0 ;i<100;i++){
            Hello hello = new Hello();
            hello.setId((long) i);
            hello.setName("name"+i);
            hello.setDate(new Date(System.currentTimeMillis() - random.nextInt(1000)*200));
            hello.setSex(i % 2 == 0);
            hellos.add(hello);
        }
        hellos.forEach(r -> helloDao.add(r));
    }

    @Test
    public void testDelete(){
       Hello hello = new Hello();
        hello.setName("name"+1);
        helloDao.delete(hello);
    }

    @Test
    public void testUpdate(){
        Hello hello = new Hello();
        hello.setName("name"+10);
        hello.setSex(false);
        hello.setDate(new Date(System.currentTimeMillis()));
        helloDao.update(hello);
    }
    @Test
    public void testFind(){
        Hello hello = new Hello();
        hello.setId(10L);
        hello = helloDao.find(hello);

        System.out.println(hello);
    }


}
