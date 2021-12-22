package com.allen.annotataions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于定于区域的注解
 * Retention：生命周期
 * Target：出现位置
 * @author zhoutao
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface District {

    /**
     * 用于指定区域名称
     * @return
     */
    String value();
}
