/*
 * create by 2021年5月8日 下午2:25:16
 */
package com.demo.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author fangang
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
