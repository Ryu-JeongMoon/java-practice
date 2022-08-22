package org.designpattern.construction.abstract_factory._01_after.factory;

import org.designpattern.construction.abstract_factory._01_after.domain.AdvancedAnchor;
import org.designpattern.construction.abstract_factory._01_after.domain.AdvancedWheel;
import org.designpattern.construction.abstract_factory._01_after.domain.Anchor;
import org.designpattern.construction.abstract_factory._01_after.domain.Wheel;

public class AdvancedPartsFactory implements PartsFactory {

	@Override
	public Anchor createAnchor() {
		return new AdvancedAnchor();
	}

	@Override
	public Wheel createWheel() {
		return new AdvancedWheel();
	}
}
