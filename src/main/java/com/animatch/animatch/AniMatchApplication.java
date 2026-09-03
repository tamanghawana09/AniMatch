package com.animatch.animatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AniMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(AniMatchApplication.class, args);
        System.out.println("Anime application has started");
    }

}
