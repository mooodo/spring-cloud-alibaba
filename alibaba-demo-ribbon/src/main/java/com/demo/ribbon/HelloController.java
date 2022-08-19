/*
 * Created by 2021-03-26 21:06:28 
 */
package com.demo.ribbon;

import java.util.Map;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author fangang
 */
@RestController
@RequestMapping("ribbon")
public class HelloController {
	@Autowired
	private RestTemplate restTemplate;
	@GetMapping("sayHello")
	@SentinelResource(value = "sayHello", fallback = "error")
	public String sayHello(String user) {
		String url = "http://service-hello/sayHello?user= {user}";
		return restTemplate.getForObject(url, String.class, user);
	}
	@GetMapping("showMe")
	@SentinelResource("showMe")
	public Person showMe() {
		String url = "http://service-hello/showMe";
		return restTemplate.getForObject(url, Person.class);
	}
	
	@PostMapping("findPerson")
	@SentinelResource("findPerson")
	public Person findPerson(@RequestBody Map<String, String> param) {
		String url = "http://service-hello/findPerson";
		return restTemplate.postForObject(url, param, Person.class);
	}

	public String error(String user, Throwable e) {
		return "Sorry, something wrong!";
	}
}
