package org.designpattern.construction.abstract_factory._01_after.factory;

import org.designpattern.construction.abstract_factory._01_after.domain.Anchor;
import org.designpattern.construction.abstract_factory._01_after.domain.Wheel;
import org.designpattern.construction.abstract_factory._02_before.BasicAnchor;
import org.designpattern.construction.abstract_factory._02_before.BasicWheel;

public class BasicPartsFactory implements PartsFactory {

	@Override
	public Wheel createWheel() {
		return new BasicWheel();
	}

	@Override
	public Anchor createAnchor() {
		return new BasicAnchor();
	}

}
