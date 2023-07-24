package com.example.poet17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Poet17Application {

    public static void main(String[] args) {
        SpringApplication.run(Poet17Application.class, args);
    }

}
