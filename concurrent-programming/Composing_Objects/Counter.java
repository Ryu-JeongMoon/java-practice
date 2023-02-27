package net.jcip.examples;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * Counter
 * <p/>
 * Simple thread-safe counter using the Java monitor pattern
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public final class Counter {

  @GuardedBy("this")
  private long value = 0;

  public synchronized long getValue() {
    return value;
  }

  public synchronized long increment() {
    if (value == Long.MAX_VALUE) {
      throw new IllegalStateException("counter overflow");
    }
    return ++value;
  }
}

/*
Java Monitor Pattern, 자바의 암묵적인 락을 사용하는 패턴
1. 캡슐화로 데이터를 인스턴스 한정시키고
2. 암묵적인 락 (monitor lock)을 사용해 데이터에 대한 동시 접근을 제어한다

mutual exclusion, synchronization 을 모두 확보하는 방법
가시성을 private 으로 제한해 접근 방법을 하나만 열어둠 (getter, setter ... 등 특정 메서드)
그 메서드에서는 암묵적인 락을 사용해 동시 접근 제어
 */