/*
 * Created by 2020-05-04 11:39:47 
 */
package com.demo.feign;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author fangang
 */
@RestController
@RequestMapping("feign")
public class ClientController {
	@Autowired
	private HelloService service;
	@GetMapping("sayHello")
	public String sayHello(String user) {
		return service.sayHello(user);
	}
	@GetMapping("showMe")
	public Person showMe() {
		return service.showMe();
	}
	@PostMapping("findPerson")
	public Person findPerson(@RequestParam Map<String,String> param) {
		return service.findPerson(param);
	}
}
