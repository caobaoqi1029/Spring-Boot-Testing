package jzxy.cbq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootTestingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestingApplication.class, args);

        log.info("SpringBootTestingApplication run successful ");
    }

}
