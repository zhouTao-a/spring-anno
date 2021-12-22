package com.allen.service.northImpl;

import com.allen.annotataions.District;
import com.allen.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * 华北地区分成实现类
 */
@Service("districtPercentage")
@District("north")
public class NorthDistrictPercentage implements DistrictPercentage {

    @Override
    public void salePercentage(String type) {
        if ("SUV".equalsIgnoreCase(type)) {
            System.out.println("华北区" + type + "分成1%");
        }else if ("CAR".equalsIgnoreCase(type)) {
            System.out.println("华北区" + type + "分成0.5%");
        }
    }
}
