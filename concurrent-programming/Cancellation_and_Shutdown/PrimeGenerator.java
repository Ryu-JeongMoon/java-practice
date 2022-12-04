package net.jcip.examples;

import static java.util.concurrent.TimeUnit.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * PrimeGenerator
 * <p/>
 * Using a volatile field to hold cancellation state
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class PrimeGenerator implements Runnable {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();

	@GuardedBy("this")
	private final List<BigInteger> primes = new ArrayList<>();

	// it should be volatile to make sure that the value is visible to all threads
	private volatile boolean cancelled;

	static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
		PrimeGenerator generator = new PrimeGenerator();
		EXECUTOR_SERVICE.execute(generator);

		try {
			SECONDS.sleep(1);
		} finally {
			generator.cancel();
		}

		return generator.get();
	}

	@Override
	public void run() {
		BigInteger p = BigInteger.ONE;

		// busy waiting ...
		while (!cancelled) {
			p = p.nextProbablePrime();
			synchronized (this) {
				primes.add(p);
			}
		}
	}

	public void cancel() {
		cancelled = true;
	}

	public synchronized List<BigInteger> get() {
		return Collections.unmodifiableList(primes);
	}
}
