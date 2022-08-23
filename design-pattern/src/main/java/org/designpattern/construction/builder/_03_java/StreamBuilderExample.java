package org.designpattern.construction.builder._03_java;

import java.util.stream.Stream;

public class StreamBuilderExample {

	public static void main(String[] args) {
		Stream.<String>builder()
			.add("Hello")
			.add("World")
			.add("!")
			.add("Java")
			.add("Stream")
			.add("Builder")
			.build()
			.forEach(System.out::println);
	}
}

/*
todo, Stream. 점 찍고 제네릭 지정해줘야 되넹 이건 왜인고?
 */