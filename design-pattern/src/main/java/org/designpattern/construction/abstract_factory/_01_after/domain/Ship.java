package org.designpattern.construction.abstract_factory._01_after.domain;

public interface Ship {

	Wheel getWheel();

	Anchor getAnchor();

	void setWheel(Wheel wheel);

	void setAnchor(Anchor anchor);
}
