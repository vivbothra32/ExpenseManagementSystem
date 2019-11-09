package com.cg.ems.finance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@ComponentScan("com.cg.ems.finance")
public class FinanceModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceModuleApplication.class, args);
	}

}
