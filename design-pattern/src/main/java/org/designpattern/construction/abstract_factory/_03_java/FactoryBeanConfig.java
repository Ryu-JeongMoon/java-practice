package org.designpattern.construction.abstract_factory._03_java;

import org.designpattern.construction.abstract_factory._01_after.factory.ShipFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryBeanConfig {

	@Bean
	public ShipFactory shipFactory() {
		return new ConcreteShipFactory();
	}
}
