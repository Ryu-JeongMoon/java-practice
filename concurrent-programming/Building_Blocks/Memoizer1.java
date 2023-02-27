package net.jcip.examples;

import net.jcip.annotations.GuardedBy;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

interface Computable<A, V> {

	V compute(A arg) throws InterruptedException;
}

/**
 * Memoizer1
 * <p>
 * Initial cache attempt using HashMap and synchronization
 *
 * @author Brian Goetz and Tim Peierls
 */
public class Memoizer1<A, V> implements Computable<A, V> {

	@GuardedBy("this")
	private final Map<A, V> cache = new HashMap<>();

	// computable#compute 는 매우 오래 걸리는 작업이라 가정
	private final Computable<A, V> c;

	public Memoizer1(Computable<A, V> c) {
		this.c = c;
	}

	/**
	 * <pre>
	 * 가장 간단한 동기화 방법으로 synchronized-method 사용
	 * 만약 캐시에 없어서 compute 수행해야 되면 성능 구데기 됨
	 * 이전 값과 다른 값을 요청하게 되면
	 * 두번째 요청은 첫번째 요청을 기다린 후 또 다시 compute 수행해야 됨
	 * 즉, 동시에 여러 스레드가 사용하면 캐시를 적용하지 않은 것보다 성능 구데기 됨</pre>
	 */
	public synchronized V compute(A arg) throws InterruptedException {
		V result = cache.get(arg);
		if (result == null) {
			result = c.compute(arg);
			cache.put(arg, result);
		}
		return result;
	}
}

class ExpensiveFunction
		implements Computable<String, BigInteger> {

	public BigInteger compute(String arg) {
		// after deep thought...
		return new BigInteger(arg);
	}
}
