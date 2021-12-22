package com.allen.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 测试spring注解驱动开发的入门案例
 * @author zhoutao
 */
public class SpringAnnotation {

    public static void main(String[] args) {
        //1、创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
        //2、根据bean的id获取对象
        JdbcTemplate bean = ac.getBean("jdbcTemplate", JdbcTemplate.class);
        //3、执行操作
        int i = bean.update("insert into t_teacher (name, code) values (?, ?)", "jdbcTemplate1", "jdbcTemplate");
        System.out.println("插入记录" + (i > 0 ? "成功" : "失败"));
    }
}
