package org.designpattern.construction.abstract_factory._01_after.factory;

import org.designpattern.construction.abstract_factory._01_after.domain.AdvancedShip;
import org.designpattern.construction.abstract_factory._01_after.domain.Ship;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AdvancedShipFactory implements ShipFactory {

	private final PartsFactory partsFactory;

	@Override
	public Ship createShip() {
		Ship ship = getShip();
		ship.setWheel(partsFactory.createWheel());
		ship.setAnchor(partsFactory.createAnchor());
		return ship;
	}

	private Ship getShip() {
		return new AdvancedShip();
	}
}
