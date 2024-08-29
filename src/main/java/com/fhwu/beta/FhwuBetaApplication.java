package com.fhwu.beta;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fhwu.beta.mapper")
public class FhwuBetaApplication {

    public static void main(String[] args) {
        SpringApplication.run(FhwuBetaApplication.class, args);
    }

}
