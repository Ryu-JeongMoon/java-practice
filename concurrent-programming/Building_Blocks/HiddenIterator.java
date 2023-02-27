package net.jcip.examples;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import net.jcip.annotations.GuardedBy;

/**
 * HiddenIterator
 * <p/>
 * Iteration hidden within string concatenation
 *
 * @author Brian Goetz and Tim Peierls
 */
public class HiddenIterator {

  @GuardedBy("this")
  private final Set<Integer> set = new HashSet<>();

  public synchronized void add(Integer i) {
    set.add(i);
  }

  public synchronized void remove(Integer i) {
    set.remove(i);
  }

  public void addTenThings() {
    Random r = new Random();
    for (int i = 0; i < 10; i++) {
      add(r.nextInt());
    }
    System.out.println("DEBUG: added ten elements to " + set);
  }
}

/*
문자열 연결 연산
DEBUG: added ten elements to " + set
  -> StringBuilder.append(Object) 로 변환
		-> set.toString() 호출
			-> set.iterator() 호출
				-> lock 잡고 순회
					-> lock 해제

Collection.toString() 내부에서 iterator 사용해 출력 형태로 바꾸기 때문에
요래서 hidden-iterator

상태 변수의 동기화를 맞춰주는 락이 멀리 떨어져 있을수록 까먹기 쉽당
toString() 호출에 락을 걸어야 한다니 대체 누가 알았겠는가 ?
AbstractCollection#toString() 참고 (equals, hashCode 도 마찬가지)
 */