package com.allen.service;

/**
 * 分成的桥接接口
 * @author zhoutao
 */
public interface DistrictPercentage {

    /**
     * 根据不同的类型计算分成
     * 类型：
     *      SUV
     *      CAR
     * @param type
     */
    void salePercentage(String type);
}
