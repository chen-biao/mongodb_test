package com.cqc.test.mongodb.config;

import com.cqc.test.mongodb.common.DateConverter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.convert.CustomConversions;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.*;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: chenqianchong
 * @Date: 2019/10/13 16:01
 */
@Configuration
public class MongoDBConfig {

    @Bean
    public MongoTemplate getMongoTemplate(MongoDbFactory dbFactory, MappingMongoConverter converter) {
        MongoTemplate template = new MongoTemplate(dbFactory, converter);
        return template;
    }

    @Bean
    public MappingMongoConverter mappingMongoConverter(MongoDbFactory factory, MongoMappingContext context, BeanFactory beanFactory, MongoCustomConversions customConversions) {
        DbRefResolver dbRefResolver = new DefaultDbRefResolver(factory);
        MappingMongoConverter mappingConverter = new MappingMongoConverter(dbRefResolver, context);
        mappingConverter.setCustomConversions(beanFactory.getBean(CustomConversions.class));
        mappingConverter.setTypeMapper(new DefaultMongoTypeMapper(null));//去掉默认mapper添加的_class
        mappingConverter.setCustomConversions(customConversions);//添加自定义的转换器
        return mappingConverter;
    }

    @Bean
    public MongoCustomConversions customConversions() {
        List list = new ArrayList();
        list.add(new DateConverter());
        return new MongoCustomConversions(list);
    }
}
