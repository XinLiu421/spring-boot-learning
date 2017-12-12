package org.leon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Chapter1Application {

    @Bean
    public Runnable createRunnable(){
        return () -> System.out.println("spring boot is running");
    }

    public static void main(String[] args) {
        SpringApplication.run(Chapter1Application.class, args);
    }
}
