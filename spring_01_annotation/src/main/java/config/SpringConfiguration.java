package config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * spring的配置类，相当于applicationContext.xml的作用
 *
 * @author zhoutao
 */
@Configuration
@PropertySource(value = "classpath:jdbc.properties")
@Import(JdbcConfig.class)
public class SpringConfiguration {
}
