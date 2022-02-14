package com.imodupsy.sanitytest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SanityTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SanityTestApplication.class, args);
        log.info("\n\n================================= APPLICATION LAUNCHED!!! ===============================\n\n");
    }

}
