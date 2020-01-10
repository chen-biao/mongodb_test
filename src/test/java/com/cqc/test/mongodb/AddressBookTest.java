package com.cqc.test.mongodb;

import com.cqc.test.mongodb.entity.AddressBook;
import com.cqc.test.mongodb.entity.PasreAndRaw;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * @Author: chenqianchong
 * @Date: 2019/10/16 21:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressBookTest {

    @Autowired
    MongoTemplate mongoTemplate;

    public void gitcommittest(){
        System.out.println(1);
        System.out.println(2);
        System.out.println(3);
        System.out.println(4);

    }

//    @Autowired
//    jdbcTemplate

    Random random = new Random();


    @Test
    public void testInsert(){


        Map<Long,Object> userIds = new HashMap<>();
        for(long id = 100000000L ;id < 100010000L ; id+=2){
            userIds.put(id,null);
        }

        userIds.forEach((id,va)-> {
            AddressBook addressBook = new AddressBook();
            addressBook.setUserId(id);
            List<PasreAndRaw> lists = new ArrayList<>();
            for(int i = 0;i < 10000;i++){
                PasreAndRaw pasreAndRaw = new PasreAndRaw();
                pasreAndRaw.setCodeMobile(i * random.nextLong() );
                pasreAndRaw.setRawData(getRawData());


                lists.add(pasreAndRaw);
            }
            addressBook.setLists(lists);
            mongoTemplate.save(addressBook);
        });




    }

    public static void main(String[] args) {
        ObjectId objectId = new ObjectId();
        System.out.println(objectId.toString());
        System.out.println(objectId.toHexString());


    }

    private String getRawData(){
        int langth =  8 + random.nextInt(9);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ;i<langth;i++){
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }
}
