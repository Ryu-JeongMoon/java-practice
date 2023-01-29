package org.designpattern.behavior.observer._02_after;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class ChatServer {

	private final MultiValueMap<String, Subscriber> subscribers = new LinkedMultiValueMap<>();

	public void register(String subject, Subscriber subscriber) {
		subscribers.add(subject, subscriber);
	}

	// WeakReference ?!
	public void unregister(String subject, Subscriber subscriber) {
		if (subscribers.containsKey(subject)) {
			subscribers.get(subject).remove(subscriber);
		}
	}

	public void sendMessage(Subscriber subscriber, String subject, String message) {
		subscribers.computeIfPresent(subject, (k, v) -> {
			String messageToBeSent = "-> [%s]: %s".formatted(subscriber.name(), message);
			v.forEach(s -> s.handleMessage(s.name(), messageToBeSent));
			return v;
		});
	}
}
