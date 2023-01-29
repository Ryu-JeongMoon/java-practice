package org.designpattern.behavior.observer._03_java;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements ApplicationRunner {

	private final ApplicationEventPublisher publisher;

	public MyRunner(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public void run(ApplicationArguments args) {
		publisher.publishEvent(new MyEvent("팬더"));
	}
}
