package kg.java.testtodo.configuration.priorityconfig;

import kg.java.testtodo.mappers.prioritymapper.PriorityMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PriorityConfig {
    @Bean
    public PriorityMapper buildPriorityMapper(){
        return new PriorityMapper();
    }
}
