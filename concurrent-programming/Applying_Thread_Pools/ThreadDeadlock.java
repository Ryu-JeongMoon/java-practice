package net.jcip.examples;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ThreadDeadlock
 * <p/>
 * basic.oop.Task that deadlocks in a single-threaded Executor
 *
 * @author Brian Goetz and Tim Peierls
 */
public class ThreadDeadlock {

  ExecutorService exec = Executors.newSingleThreadExecutor();

  public static class LoadFileTask implements Callable<String> {

    private final String fileName;

    public LoadFileTask(String fileName) {
      this.fileName = fileName;
    }

    public String call() throws Exception {
      // Here's where we would actually read the file
      return "";
    }
  }

  public class RenderPageTask implements Callable<String> {

    public String call() throws Exception {
      Future<String> header, footer;
      header = exec.submit(new LoadFileTask("header.html"));
      footer = exec.submit(new LoadFileTask("footer.html"));
      String page = renderBody();
      // Will deadlock -- task waiting for result of subtask
      return header.get() + page + footer.get();
    }

    private String renderBody() {
      // Here's where we would actually render the page
      return "";
    }
  }
}

/*
완전히 독립적이지 않은 task들을 스레드 풀에 제출하면, thread starvation deadlock 걸릴 가능성이 높다
자원에 의존적인 스레드 풀을 사용한다면 (ex. jdbc connection)
동시에 실행되는 작업의 수는 스레드 풀에 있는 스레드 개수가 몇개든 자원의 수로 제한될 수 있다
 */