package org.designpattern.construction.singleton;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringExample {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		String hello1 = context.getBean("hello", String.class);
		String hello2 = context.getBean("hello", String.class);
		System.out.println((hello1.equals(hello2)));
	}
}

/*
Spring의 Bean 관리 scope 중 Singleton Scope
 */