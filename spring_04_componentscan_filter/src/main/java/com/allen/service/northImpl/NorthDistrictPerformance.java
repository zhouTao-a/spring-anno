package com.allen.service.northImpl;

import com.allen.annotataions.District;
import com.allen.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * 华北地区绩效实现类
 */
@Service("districtPerformance")
@District("north")
public class NorthDistrictPerformance implements DistrictPerformance {

    @Override
    public void calcPerformance(String type) {
        if ("SUV".equalsIgnoreCase(type)) {
            System.out.println("华北区" + type + "绩效5%");
        }else if ("CAR".equalsIgnoreCase(type)) {
            System.out.println("华北区" + type + "绩效3%");
        }
    }
}
