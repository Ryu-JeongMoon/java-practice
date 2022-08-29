package org.designpattern.structure.bridge._02_after;

public abstract class App implements Champion {

	public static void main(String[] args) {
		Champion kdaAri = new Ari(new Kda());
		kdaAri.skillQ();
		kdaAri.skillW();

		Champion poolPartyAri = new Ari(new PoolParty());
		poolPartyAri.skillR();
		poolPartyAri.skillW();
	}
}
