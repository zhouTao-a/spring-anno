package com.allen.test;

import com.allen.service.UserService;
import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfigurationTest {

    public static void main(String[] args) {
        //1、创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、获取对象
        UserService userService = ac.getBean("myuserService", UserService.class);
        //3、调用方法
        userService.saveUser();
    }
}
