package kg.java.testtodo.configuration.userconfig;

import kg.java.testtodo.mappers.usermapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    UserMapper buildUserMapper() {
        return new UserMapper();
    }
}
