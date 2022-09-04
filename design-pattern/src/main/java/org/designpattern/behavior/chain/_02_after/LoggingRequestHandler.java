package org.designpattern.behavior.chain._02_after;

import org.designpattern.behavior.chain._01_before.Request;

public class LoggingRequestHandler extends RequestHandler {

	public LoggingRequestHandler(RequestHandler nextHandler) {
		super(nextHandler);
	}

	@Override
	public void handle(Request request) {
		log.info("logging blah-blah");
		super.handle(request);
	}
}
