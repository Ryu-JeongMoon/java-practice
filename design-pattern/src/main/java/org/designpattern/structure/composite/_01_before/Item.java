package org.designpattern.structure.composite._01_before;

public class Item {

	private final String name;

	private final int price;

	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public int getPrice() {
		return this.price;
	}
}
