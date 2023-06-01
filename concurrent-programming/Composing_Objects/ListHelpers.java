package net.jcip.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.jcip.annotations.NotThreadSafe;
import net.jcip.annotations.ThreadSafe;

/**
 * ListHelder
 * <p/>
 * Examples of thread-safe and non-thread-safe implementations of put-if-absent helper methods for List
 *
 * @author Brian Goetz and Tim Peierls
 */

@NotThreadSafe
class BadListHelper<E> {

  public List<E> list = Collections.synchronizedList(new ArrayList<>());

  /**
   * <pre>
   * 이게 왜 문제가 되는가? synchronized 걸 때 어떤 락을 쓰는지가 중요함
   * BadListHelper의 암묵적인 락으로 동기화를 하니
   * synchronizedList 의 락과 아다리가 맞지 않는다
   * 따라서 List의 입장에서 이 메서드는 단일 연산이 아니라고 볼 수 있다 ?!
   * 즉 여기서 락을 걸어봤자 BadListHelper로의 동시 접근을 막는 것이지
   * List 자체의 contains, add 를 동기화 해주는 것이 아니다 !!</pre>
   */
  public synchronized boolean putIfAbsent(E x) {
    boolean absent = !list.contains(x);
    if (absent) {
      list.add(x);
    }
    return absent;
  }
}

@ThreadSafe
class GoodListHelper<E> {

  public final List<E> list = Collections.synchronizedList(new ArrayList<>());

  public boolean putIfAbsent(E x) {
    synchronized (list) {
      boolean absent = !list.contains(x);
      if (absent) {
        list.add(x);
      }
      return absent;
    }
  }
}
