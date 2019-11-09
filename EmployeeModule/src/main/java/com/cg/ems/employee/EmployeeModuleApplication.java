package com.cg.ems.employee;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cg.ems.employee"})
public class EmployeeModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeModuleApplication.class, args);
	}

}
