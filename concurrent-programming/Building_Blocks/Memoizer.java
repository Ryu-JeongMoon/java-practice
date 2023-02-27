package net.jcip.examples;

import java.util.concurrent.*;

/**
 * Memoizer
 * <p/>
 * Final implementation of Memoizer
 *
 * @author Brian Goetz and Tim Peierls
 */
public class Memoizer<A, V> implements Computable<A, V> {

	// memoizer2의 약점으로 이미 실행한 작업이 짧은 시간 안에 요청되면
	// 결과 값을 받기 전에는 비어있다고 판단해 다시 실행될 수 있음
	// memoizer 최종본은 이를 해결하기 위해 FutureTask 사용
	private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<>();
	private final Computable<A, V> c;

	public Memoizer(Computable<A, V> c) {
		this.c = c;
	}

	public V compute(final A arg) throws InterruptedException {
		while (true) {
			Future<V> f = cache.get(arg);
			if (f == null) {
				Callable<V> eval = () -> c.compute(arg);
				FutureTask<V> ft = new FutureTask<>(eval);
				// 확인 후 삽입
				f = cache.putIfAbsent(arg, ft);
				if (f == null) {
					f = ft;
					ft.run();
				}
			}

			try {
				return f.get();
			} catch (CancellationException e) {
				// FutureTask가 취소되었을 경우, 캐시에서 제거
				cache.remove(arg, f);
			} catch (ExecutionException e) {
				throw LaunderThrowable.launderThrowable(e.getCause());
			}
		}
	}
}

/*
캐시 만료가 필요하다면 FutureTask를 확장해 만료 시간 관련 기능을 추가
 */