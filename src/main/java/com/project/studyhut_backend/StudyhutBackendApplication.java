package com.project.studyhut_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class StudyhutBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudyhutBackendApplication.class, args);
    }

}
