package net.jcip.examples;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * BrokenPrimeProducer
 * <p/>
 * Unreliable cancellation that can leave producers stuck in a blocking operation
 *
 * @author Brian Goetz and Tim Peierls
 */
class BrokenPrimeProducer extends Thread {

  private final BlockingQueue<BigInteger> queue;

  private volatile boolean cancelled = false;

  BrokenPrimeProducer(BlockingQueue<BigInteger> queue) {
    this.queue = queue;
  }

  public void run() {
    try {
      BigInteger p = BigInteger.ONE;
      while (!cancelled) {
        queue.put(p = p.nextProbablePrime());
      }
    } catch (InterruptedException ignored) {
    }
  }

  public void cancel() {
    cancelled = true;
  }
}

/*
외부에서 cancel 호출해 취소시키려 해도 queue.put() 블로킹 상태에서 취소가 안됨

interrupt 걸면 왜 InterruptedException 발생하는가?
Thread.sleep(), Object.wait() 같은 블로킹 메서드들은 interrupt 상태를 확인하고 있다가
interrupted -> true인 경우, interrupted() 호출하여 인터럽트 상태를 해제한 후 InterruptedException 발생시킴

Thread.interrupted()
인터럽트 상태 해제 후, 이전 상태 값을 반환하는 요상한 메서드

Thread Non-Blocked 상태라면 InterruptedException 발생하지 않음
즉, 인터럽트가 발생하더라도 '실행 중단하라' 라는 요청이 올 뿐 이후 작업은 스레드가 알아서 처리해야 함
 */