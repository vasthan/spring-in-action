package ioc;

import org.springframework.context.annotation.Bean;

public class BeanConfiguration {

    @Bean
    public HelloService hello() {
        return new HelloServiceImpl(System.out);
    }
}
