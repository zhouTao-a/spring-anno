package config;

import com.typefilter.DistrictTypeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * spring配置类
 * @author zhoutao
 */
@Configuration
@ComponentScan(value = "com.allen",
        excludeFilters = @ComponentScan.Filter(type = FilterType.CUSTOM, classes = DistrictTypeFilter.class))
public class SpringConfiguration {
}
