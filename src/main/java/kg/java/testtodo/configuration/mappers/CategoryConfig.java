package kg.java.testtodo.configuration.mappers;

import kg.java.testtodo.core.mappers.categorymapper.CategoryMapper;
import kg.java.testtodo.core.mappers.prioritymapper.PriorityMapper;
import kg.java.testtodo.core.mappers.usermapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoryConfig {

    @Bean
    public CategoryMapper buildCategoryMapper(){
        return new CategoryMapper();
    }


    @Bean
    public PriorityMapper buildPriorityMapper(){
        return new PriorityMapper();
    }
    @Bean
    UserMapper buildUserMapper() {
        return new UserMapper();
    }
}
