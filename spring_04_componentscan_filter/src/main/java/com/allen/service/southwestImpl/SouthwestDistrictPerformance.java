package com.allen.service.southwestImpl;

import com.allen.annotataions.District;
import com.allen.service.DistrictPerformance;
import org.springframework.stereotype.Service;

/**
 * 西南区绩效实现类
 */
@Service("districtPerformance")
@District("southwest")
public class SouthwestDistrictPerformance implements DistrictPerformance {

    @Override
    public void calcPerformance(String type) {
        if ("SUV".equalsIgnoreCase(type)) {
            System.out.println("西南区" + type + "绩效3%");
        }else if ("CAR".equalsIgnoreCase(type)) {
            System.out.println("西南区" + type + "绩效5%");
        }
    }
}
