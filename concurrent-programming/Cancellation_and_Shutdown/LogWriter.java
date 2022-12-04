package net.jcip.examples;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * LogWriter
 * <p/>
 * Producer-consumer logging service with no shutdown support
 *
 * @author Brian Goetz and Tim Peierls
 */
public class LogWriter {

	private static final int CAPACITY = 1000;

	private final LoggerThread logger;
	private final BlockingQueue<String> queue;

	private volatile boolean shutdownRequested;

	public LogWriter(Writer writer) {
		this.logger = new LoggerThread(writer);
		this.queue = new LinkedBlockingQueue<>(CAPACITY);
	}

	public void start() {
		logger.start();
	}

	public void shutDown() {
		shutdownRequested = true;
	}

	public void log(String msg) throws InterruptedException {
		queue.put(msg);
	}

	public void unsafeLog(String msg) throws InterruptedException {
		if (shutdownRequested) {
			throw new IllegalArgumentException("logger is shutdown");
		}

		queue.put(msg);
	}

	private class LoggerThread extends Thread {

		private final PrintWriter writer;

		public LoggerThread(Writer writer) {
			this.writer = new PrintWriter(writer, true);
		}

		public void run() {
			try {
				while (true) {
					writer.println(queue.take());
				}
			} catch (InterruptedException ignored) {
			} finally {
				writer.close();
			}
		}
	}
}

/*
multi-producer, single-consumer
각자의 스레드들은 로깅할 내용을 LogWriter에 넘겨만 주고 처리는 LogWriter가 알아서 수행 한다
BlockingQueue로 동작하기 때문에 Back-Pressure 필요할 수도 있듬

이런 방식으로 구현하면 JVM 종료하려 해도 LogWriter 스레드가 계속 실행되느라 종료되지 않을 수 있듬
shutdown 메소드와 같이 종료시킬 수 있는 메소드를 추가해야 함
특히 로깅 대기 중이던 내용을 모두 출력 후 종료해야 하므로 graceful-shutdown 방식으로 가야 함

이를 위해 flag 추가해 상태 관리 필요
- isShutDown ?
- true -> 대기 큐에 넣지 못하게 하고 대기 중인 내용 모두 출력 후 큐 비어있다면 스레드 종료
- false -> 계속 처리
 */