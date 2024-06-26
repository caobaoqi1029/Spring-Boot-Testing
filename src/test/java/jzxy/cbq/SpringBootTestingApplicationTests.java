package jzxy.cbq;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

@SpringBootTest
class SpringBootTestingApplicationTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void contextLoads() {
        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
    }

}
