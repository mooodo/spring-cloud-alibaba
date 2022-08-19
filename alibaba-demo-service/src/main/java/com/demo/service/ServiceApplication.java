/*
 * Created by 2021-03-26 20:15:43 
 */
package com.demo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;

/**
 * @author fangang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceApplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
	@Bean
	public SentinelResourceAspect sentinelResourceAspect() {
		return new SentinelResourceAspect();
	}
}
