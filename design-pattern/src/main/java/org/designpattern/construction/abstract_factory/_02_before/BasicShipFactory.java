package org.designpattern.construction.abstract_factory._02_before;

import org.designpattern.construction.abstract_factory._01_after.domain.AdvancedAnchor;
import org.designpattern.construction.abstract_factory._01_after.domain.AdvancedShip;
import org.designpattern.construction.abstract_factory._01_after.domain.AdvancedWheel;
import org.designpattern.construction.abstract_factory._01_after.domain.Ship;
import org.designpattern.construction.abstract_factory._01_after.factory.ShipFactory;

public class BasicShipFactory implements ShipFactory {

	@Override
	public Ship createShip() {
		BasicShip basicShip = new BasicShip();
		basicShip.setWheel(new BasicWheel());
		basicShip.setAnchor(new BasicAnchor());
		return basicShip;
	}

	public Ship createAdvancedShip() {
		AdvancedShip advancedShip = new AdvancedShip();
		advancedShip.setWheel(new AdvancedWheel());
		advancedShip.setAnchor(new AdvancedAnchor());
		return advancedShip;
	}
}