package org.designpattern.behavior.chain._01_before;

public class RequestHandler {

	public void handler(Request request) {
		System.out.println(request.body());
	}
}
