package com.waimou.epidemic_personnel_management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.waimou.epidemic_personnel_management_system.service.*.mapper*")
public class EpidemicPersonnelManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpidemicPersonnelManagementSystemApplication.class, args);
    }

}
