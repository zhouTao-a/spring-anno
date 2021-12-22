package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Spring配置类
 */
@Configuration
public class SpringConfigguration {

    /**
     * 创建dataSource对象
     * @return
     */
    @Bean
    public DataSource getDataSource(){
        return new DriverManagerDataSource();
    }
}
