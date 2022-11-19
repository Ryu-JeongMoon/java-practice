package net.jcip.examples;

import net.jcip.annotations.GuardedBy;

/**
 * PrivateLock
 * <p/>
 * Guarding state with a private lock
 *
 * @author Brian Goetz and Tim Peierls
 */
public class PrivateLock {

	private final Object myLock = new Object();

	@GuardedBy("myLock")
	Widget widget;

	void someMethod() {
		synchronized (myLock) {
			// Access or modify the state of widget
		}
	}
}

/*
monitor lock 은 관례일 뿐이므로 스레드 안전성만 지켜진다면 어떤 락을 사용하든 상관 없다
간단한 객체에서는 암묵적인 락을 두고 굳이 락을 위한 객체를 만들어 사용할 필요가 없어서 java monitor pattern 을 따르도록 한다
 */