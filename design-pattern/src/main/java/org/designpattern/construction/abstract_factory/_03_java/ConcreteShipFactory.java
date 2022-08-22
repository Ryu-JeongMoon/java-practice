package org.designpattern.construction.abstract_factory._03_java;

import org.designpattern.construction.abstract_factory._01_after.domain.Ship;
import org.designpattern.construction.abstract_factory._01_after.factory.AdvancedPartsFactory;
import org.designpattern.construction.abstract_factory._01_after.factory.AdvancedShipFactory;
import org.designpattern.construction.abstract_factory._01_after.factory.ShipFactory;
import org.springframework.beans.factory.FactoryBean;

public class ConcreteShipFactory implements FactoryBean<Ship>, ShipFactory {

	@Override
	public Ship getObject() {
		return new AdvancedShipFactory(new AdvancedPartsFactory()).createShip();
	}

	@Override
	public Class<?> getObjectType() {
		return Ship.class;
	}

	@Override
	public Ship createShip() {
		return getObject();
	}
}
