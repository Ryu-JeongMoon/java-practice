package org.designpattern.behavior.chain._02_after;

import org.designpattern.behavior.chain._01_before.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class RequestHandler {

	protected final Logger log = LoggerFactory.getLogger(getClass());

	private final RequestHandler nextHandler;

	public RequestHandler(RequestHandler nextHandler) {
		this.nextHandler = nextHandler;
	}

	public void handle(Request request) {
		if (nextHandler != null) {
			nextHandler.handle(request);
		}
	}
}
