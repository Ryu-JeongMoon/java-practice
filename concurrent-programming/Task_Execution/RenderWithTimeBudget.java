package net.jcip.examples;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

/**
 * RenderWithTimeBudget
 * <p>
 * Fetching an advertisement with a time budget
 *
 * @author Brian Goetz and Tim Peierls
 */
public class RenderWithTimeBudget {

  private static final Ad DEFAULT_AD = new Ad();
  private static final long TIME_BUDGET = 1000;
  private static final ExecutorService exec = Executors.newCachedThreadPool();

  Page renderPageWithAd() throws InterruptedException {
    long endNanos = System.nanoTime() + TIME_BUDGET;
    // submit
    Future<Ad> f = exec.submit(new FetchAdTask());

    // Render the page while waiting for the ad
    Page page = renderPageBody();
    Ad ad;

    try {
      // Only wait for the remaining time budget
      long timeLeft = endNanos - System.nanoTime();

      // execution
      ad = f.get(timeLeft, NANOSECONDS);
    } catch (ExecutionException e) {
      ad = DEFAULT_AD;
    } catch (TimeoutException e) {
      ad = DEFAULT_AD;

      // 작업이 실행 중이라면 인터럽트 걸어도 된다
      f.cancel(true);
    }

    page.setAd(ad);
    return page;
  }

  Page renderPageBody() {
    return new Page();
  }

  static class Ad {

  }

  static class Page {

    public void setAd(Ad ad) {
    }
  }

  static class FetchAdTask implements Callable<Ad> {

    public Ad call() {
      return new Ad();
    }
  }
}

