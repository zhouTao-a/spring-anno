package com.allen.test;

import config.SpringConfigguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.sql.DataSource;


public class SpringBeanTest {

    public static void main(String[] args) {
        //1、创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfigguration.class);
        //2、获取对象
        DataSource getDataSource = ac.getBean("getDataSource", DataSource.class);
        //3、输出
        System.out.println(getDataSource);
    }
}
