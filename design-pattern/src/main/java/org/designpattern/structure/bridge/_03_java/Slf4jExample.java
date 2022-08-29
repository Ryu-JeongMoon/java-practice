package org.designpattern.structure.bridge._03_java;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jExample {

	private static final Logger logger = LoggerFactory.getLogger(Slf4jExample.class);

	public static void main(String[] args) {
		logger.info("hello logger");
	}
}
