package org.designpattern.structure.bridge._01_before;

public class KdaAri implements Champion {

	@Override
	public void move() {
		System.out.println("KDA 아리 move");
	}

	@Override
	public void skillQ() {
		System.out.println("KDA 아리 Q");
	}

	@Override
	public void skillW() {
		System.out.println("KDA 아리 W");
	}

	@Override
	public void skillE() {
		System.out.println("KDA 아리 E");
	}

	@Override
	public void skillR() {
		System.out.println("KDA 아리 R");
	}

	@Override
	public String getName() {
		return null;
	}
}
