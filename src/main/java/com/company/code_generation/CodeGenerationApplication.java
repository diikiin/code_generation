package com.company.code_generation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories
@SpringBootApplication
public class CodeGenerationApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodeGenerationApplication.class, args);
    }

}
