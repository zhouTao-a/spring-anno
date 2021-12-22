package com.allen.test;

import com.allen.service.DistrictPercentage;
import com.allen.service.DistrictPerformance;
import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringConfiguration1 {
    public static void main(String[] args) {
        //1、创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、获取对象
        DistrictPercentage districtPercentage = ac.getBean("districtPercentage", DistrictPercentage.class);
        //3、调用方法
        districtPercentage.salePercentage("SUV");

        //2、获取对象
        DistrictPerformance districtPerformance = ac.getBean("districtPerformance", DistrictPerformance.class);
        //3、调用方法
        districtPerformance.calcPerformance("SUV");

    }
}
