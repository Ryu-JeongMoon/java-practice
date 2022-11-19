package net.jcip.examples;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * NumberRange
 * <p/>
 * Number range class that does not sufficiently protect its invariants
 *
 * @author Brian Goetz and Tim Peierls
 */

public class NumberRange {

	// INVARIANT: lower <= upper
	private final AtomicInteger lower = new AtomicInteger(0);
	private final AtomicInteger upper = new AtomicInteger(0);

	public void setLower(int i) {
		// Warning -- unsafe check-then-act
		if (i > upper.get()) {
			throw new IllegalArgumentException("can't set lower to " + i + " > upper");
		}
		lower.set(i);
	}

	public void setUpper(int i) {
		// Warning -- unsafe check-then-act
		if (i < lower.get()) {
			throw new IllegalArgumentException("can't set upper to " + i + " < lower");
		}
		upper.set(i);
	}

	public boolean isInRange(int i) {
		return (i >= lower.get() && i <= upper.get());
	}
}

/*
내부 변수 간 의존성을 가지고 있으면 (사전 조건이 있다면) 단일 연산으로 만들어줘야 한다
 */