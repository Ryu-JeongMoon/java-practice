package org.designpattern.behavior.template._02_after;

public class Client {

	public static void main(String[] args) {
		FileProcessor fileProcessor = new Multiply("number.txt");
		int result = fileProcessor.process(Integer::sum);
		System.out.println(result);
	}
}
