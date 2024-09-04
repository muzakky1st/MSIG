package com.phone.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * ComponentScan -> untuk pindati package-package yang akan digunakan di class dependency ke com.parent.service
 * EnableJpaRepositories -> memindai package yang mengandung annotatition @JpaRespositories di class interface parent-service
 * EntityScan -> pindai entity class
 *
 * @author Zikri Muzakky
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.parent.service", "com.phone.application"})
@EnableJpaRepositories(basePackages = {"com.parent.service.repository", "com.phone.application.repository"})
@EntityScan(basePackages = "com.parent.service.model")
public class PhoneApplication {

    public static void main(String[] args) {
        System.out.println("Start Phone-Application Service...");
        SpringApplication.run(PhoneApplication.class, args);
        System.out.println("Phone-Application Started.");
    }

}
