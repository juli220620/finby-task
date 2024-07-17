package com.github.juli220620;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class Main {

    public static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = SpringApplication.run(Main.class, args);
    }

}