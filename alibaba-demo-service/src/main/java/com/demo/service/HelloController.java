/*
 * Created by 2021-03-26 20:17:09 
 */
package com.demo.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fangang
 */
@RestController
public class HelloController {
	@Value("${server.port}")
	private String port;
	@GetMapping("sayHello")
	public String sayHello(String user) {
		return "hi "+user+", welcome to you! The server port is "+port;
	}
	@GetMapping("showMe")
	public Person showMe() {
		Person person = new Person();
		person.setId(0);
		person.setName("Mooodo");
		person.setGender("male");
		return person;
	}
	@PostMapping("findPerson")
	public Person findPerson(@RequestBody Map<String, String> param) {
		Person person = new Person();
		person.setId(0);
		String name = param.get("name")==null ? "Mooodo" : param.get("name");
		person.setName(name);
		String gender = param.get("gender")==null ? "male" : param.get("gender");
		person.setGender(gender);
		return person;
	}
}
