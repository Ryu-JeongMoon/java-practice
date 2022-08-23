package org.designpattern.construction.builder._03_java;

public class StringBuilderExample {

	public static void main(String[] args) {
		String result = new StringBuilder("Hello").append(" World")
			.append("!")
			.append(" Java")
			.append(" Builder")
			.toString();

		System.out.println("result = " + result);
	}
}
