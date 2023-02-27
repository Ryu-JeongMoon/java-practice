package net.jcip.examples;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

/**
 * PrimeProducer
 * <p/>
 * Using interruption for cancellation
 *
 * @author Brian Goetz and Tim Peierls
 */
public class PrimeProducer extends Thread {

  private final BlockingQueue<BigInteger> queue;

  PrimeProducer(BlockingQueue<BigInteger> queue) {
    this.queue = queue;
  }

  @Override
  public void run() {
    try {
      BigInteger p = BigInteger.ONE;

      // it is not necessary to check the interrupted status of the thread
      // though it is a good practice to do so, put is maybe long-time consumed operation
      while (!Thread.currentThread().isInterrupted()) {

        // put is a blocking method, so it will check the interrupted status of the thread
        queue.put(p = p.nextProbablePrime());
      }
    } catch (InterruptedException consumed) {
      // it is anti pattern to swallow the exception,
      // but it is not necessary to handle the exception or re-throw it
    }
  }

  public void cancel() {
    interrupt();
  }
}

/*
put() 메서드 같은 블록킹 메서드가 오랜 시간, 많은 자원을 먹는 연산이라면
while 검사 한번으로 작업을 시작하지도 않게 만들 수 있다
while interrupt 검사는 중복 같아보이더라도 충분한 의미가 있다
 */