package org.designpattern.behavior.chain._02_after;

import org.designpattern.behavior.chain._01_before.Request;

public class PrintRequestHandler extends RequestHandler {

	public PrintRequestHandler(RequestHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handle(Request request) {
		log.info("print blah-blah {}", request.body());
		super.handle(request);
	}
}
