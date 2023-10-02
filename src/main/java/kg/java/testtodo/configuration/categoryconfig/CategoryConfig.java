package kg.java.testtodo.configuration.categoryconfig;

import kg.java.testtodo.mappers.categorymapper.CategoryMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    public CategoryMapper buildCategoryMapper(){
        return new CategoryMapper();
    }
}
