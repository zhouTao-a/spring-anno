package annoration;

import org.springframework.context.annotation.Bean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义Bean
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Bean
public @interface MyBean {


}

