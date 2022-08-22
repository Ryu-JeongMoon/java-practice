package org.designpattern.construction.abstract_factory._01_after.factory;

import org.designpattern.construction.abstract_factory._01_after.domain.Anchor;
import org.designpattern.construction.abstract_factory._01_after.domain.Wheel;

public interface PartsFactory {

	Wheel createWheel();

	Anchor createAnchor();
}
