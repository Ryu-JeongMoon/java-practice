package org.designpattern.construction.abstract_factory._01_after.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AdvancedShip implements Ship {

	private Wheel wheel;
	private Anchor anchor;

}
