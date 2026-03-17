package com.animatch.animatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class AniMatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(AniMatchApplication.class, args);
        System.out.println("Anime application has started");
    }

}
