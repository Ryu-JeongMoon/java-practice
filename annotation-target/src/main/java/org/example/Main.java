package org.example;

public class Main {

	public static void main(String[] args) {
		Source source = new Source();
		source.setName1("name1");
		source.setName2("name2");

		Target target = new Target();
		target.setName1("name1");
		target.setName2("name2");

		System.out.println(target.getName1());
		System.out.println(target.getName2());
	}
}
