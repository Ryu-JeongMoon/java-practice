package net.jcip.examples;

import java.util.List;
import java.util.Vector;

/**
 * SafeVectorHelpers
 * <p/>
 * Compound actions on Vector using client-side locking
 *
 * @author Brian Goetz and Tim Peierls
 */
public class SafeVectorHelpers {

	public static Object getLast(Vector<?> list) {
		//noinspection SynchronizationOnLocalVariableOrMethodParameter
		synchronized (list) {
			int lastIndex = list.size() - 1;
			return list.get(lastIndex);
		}
	}

	@SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
	public static void deleteLast(Vector<?> list) {
		synchronized (list) {
			int lastIndex = list.size() - 1;
			list.remove(lastIndex);
		}
	}

	@SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
	public static void main(String[] args) {
		Vector<Integer> vector = new Vector<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
		synchronized (vector) {
			for (Integer result : vector) {
				System.out.println("result = " + result);
			}
		}
	}
}

/*
main 안에 예시와 같이 client-lock 사용해 동기화할 수 있지만
1. 코드가 복잡해짐
2. 동기화 블록 안에서 다른 객체의 락을 잡으면 데드락 발생 가능
3. 반복문에 동기화를 걸면 성능 구데기
 */