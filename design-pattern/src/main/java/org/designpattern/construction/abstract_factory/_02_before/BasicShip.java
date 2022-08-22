package org.designpattern.construction.abstract_factory._02_before;

import org.designpattern.construction.abstract_factory._01_after.domain.Anchor;
import org.designpattern.construction.abstract_factory._01_after.domain.Ship;
import org.designpattern.construction.abstract_factory._01_after.domain.Wheel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
class BasicShip implements Ship {

	private Wheel wheel;
	private Anchor anchor;
}
