package test;

import config.SpringConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * 测试类
 */

public class SpringConfigurationTest {

    public static void main(String[] args) {
        //传入要扫描包的方式
//        //1、创建容器
//        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("config");
//        //2、获取对象
////        SpringConfiguration bean = ac.getBean(SpringConfiguration.class);
//        SpringConfiguration bean = ac.getBean("springConfiguration", SpringConfiguration.class);
//        //3、输出结果
//        System.out.println(bean);

        //传入被注解的类的字节码的方式
        //1、创建容器
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、获取对象
        SpringConfiguration bean = ac.getBean(SpringConfiguration.class);
        //3、输出结果
        System.out.println(bean);
    }

}
