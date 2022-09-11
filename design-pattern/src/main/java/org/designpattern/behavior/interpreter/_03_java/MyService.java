package org.designpattern.behavior.interpreter._03_java;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class MyService implements ApplicationRunner {

	@Value("#{2 + 5}")
	private String value;

	@Override
	public void run(ApplicationArguments args) {
		System.out.println(value);
	}
}
