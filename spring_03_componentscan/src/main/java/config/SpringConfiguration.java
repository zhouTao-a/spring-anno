package config;

import com.allen.service.impl.UserServiceImpl;
import com.allen.utils.CustomBeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.allen.service"}, nameGenerator = CustomBeanNameGenerator.class)
public class SpringConfiguration {
}
