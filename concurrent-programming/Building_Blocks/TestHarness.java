package net.jcip.examples;

import java.util.concurrent.CountDownLatch;

/**
 * TestHarness
 * <p/>
 * Using CountDownLatch for starting and stopping threads in timing tests
 *
 * @author Brian Goetz and Tim Peierls
 */
public class TestHarness {

  public static void main(String[] args) throws InterruptedException {
    new TestHarness().timeTasks(
      Runtime.getRuntime().availableProcessors(),
      () -> System.out.printf("%s : YAHOO\n", Thread.currentThread().getName())
    );
  }

  public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
    final CountDownLatch startGate = new CountDownLatch(1);
    final CountDownLatch endGate = new CountDownLatch(nThreads);

    for (int i = 0; i < nThreads; i++) {
      Thread t = new Thread(() -> {
        try {
          startGate.await();
          try {
            task.run();
          } finally {
            endGate.countDown();
          }

        } catch (InterruptedException ignored) {
        }
      });
      t.start();
    }

    long start = System.nanoTime();
    startGate.countDown();
    endGate.await();
    long end = System.nanoTime();
    return end - start;
  }
}
