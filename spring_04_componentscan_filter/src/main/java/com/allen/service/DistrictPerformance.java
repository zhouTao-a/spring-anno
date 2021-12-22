package com.allen.service;

/**
 * 绩效计算的桥接接口
 * @author zhoutao
 */
public interface DistrictPerformance {

    /**
     * 根据不同的类型计算绩效
     * 类型：
     *      SUV
     *      CAR
     * @param type
     */
    void calcPerformance(String type);
}
