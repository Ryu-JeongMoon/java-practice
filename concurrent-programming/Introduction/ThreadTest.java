package net.jcip.examples;

public class ThreadTest {

  public static void main(String[] args) throws InterruptedException {
    int coreCount = Runtime.getRuntime().availableProcessors();
    System.out.println("core count : " + coreCount);

    Thread[] threads = new Thread[coreCount];

    // execute each thread
    Runnable task = () -> {
      try {
        // execute task
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s start\n", threadName);
        Thread.sleep(1000);
        System.out.printf("%s end\n", threadName);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };

    // construct threads
    for (int i = 0; i < coreCount; i++) {
      threads[i] = new Thread(task, "Thread-" + (i + 1));
      threads[i].start();
    }

    // wait for all threads
    for (Thread thread : threads) {
      thread.join();
    }
  }
}
