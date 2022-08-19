/*
 * Created by 2021-03-26 21:04:20 
 */
package com.demo.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;

/**
 * @author fangang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class RibbonApplication {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	public SentinelResourceAspect sentinelResourceAspect() {
		return new SentinelResourceAspect();
	}
}
