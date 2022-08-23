package org.designpattern.construction.builder._03_java;

import lombok.Builder;

@Builder
public class LombokExample {

	private String name;

	private int age;

	private String address;

	public static void main(String[] args) {
		LombokExample example = LombokExample.builder()
			.name("홍길동")
			.age(20)
			.address("서울시 강남구")
			.build();
		System.out.println("example = " + example);
	}
}
