package org.designpattern.behavior.chain._02_after;

import org.designpattern.behavior.chain._01_before.Request;

public class AuthRequestHandler extends RequestHandler {

	public AuthRequestHandler(RequestHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handle(Request request) {
		log.info("authentication blah-blah");
		super.handle(request);
	}
}
