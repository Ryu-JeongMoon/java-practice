package org.designpattern.structure.bridge._01_before;

public class PoolPartyAri implements Champion {

	@Override
	public void move() {
		System.out.println("PoolParty move");
	}

	@Override
	public void skillQ() {
		System.out.println("PoolParty Q");
	}

	@Override
	public void skillW() {
		System.out.println("PoolParty W");
	}

	@Override
	public void skillE() {
		System.out.println("PoolParty E");
	}

	@Override
	public void skillR() {
		System.out.println("PoolParty R");
	}

	@Override
	public String getName() {
		return null;
	}
}
