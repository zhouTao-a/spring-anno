package com.allen.service.southwestImpl;

import com.allen.annotataions.District;
import com.allen.service.DistrictPercentage;
import org.springframework.stereotype.Service;

/**
 * 西南区提成实现类
 */
@Service("districtPercentage")
@District("southwest")
public class SouthwestDistrictPercentage implements DistrictPercentage {
    @Override
    public void salePercentage(String type) {
        if ("SUV".equalsIgnoreCase(type)) {
            System.out.println("西南区" + type + "分成1.5%");
        }else if ("CAR".equalsIgnoreCase(type)) {
            System.out.println("西南区" + type + "分成0.5%");
        }
    }
}
