package org.designpattern.construction.factory_method;

public class PandaShipFactory implements ShipFactory {

	@Override
	public Ship createShip() {
		return new PandaShip();
	}
}
