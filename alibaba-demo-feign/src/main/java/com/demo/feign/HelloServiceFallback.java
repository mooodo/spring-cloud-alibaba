/*
 * create by 2021年7月1日 下午3:15:39
 */
package com.demo.feign;

import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author fangang
 */
@Component
public class HelloServiceFallback implements HelloService {

	@Override
	public String sayHello(String user) {
		return "Sorry to call " + user + " failure.";
	}

	@Override
	public Person showMe() {
		return getDefault();
	}

	@Override
	public Person findPerson(Map<String, String> param) {
		return getDefault();
	}

	private Person getDefault() {
		Person person = new Person();
		person.setId(0);
		person.setName("Unknown");
		person.setGender("Unknown");
		return person;
	}
}
