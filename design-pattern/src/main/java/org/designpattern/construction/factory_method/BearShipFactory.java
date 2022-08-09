package org.designpattern.construction.factory_method;

public class BearShipFactory implements ShipFactory {

	@Override
	public Ship createShip() {
		return new BearShip();
	}
}
