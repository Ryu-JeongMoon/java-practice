package net.jcip.examples;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class LogExecutorService {

	private static final long TIMEOUT = 1000;
	private static final TimeUnit UNIT = TimeUnit.MILLISECONDS;

	private final ExecutorService exec = Executors.newSingleThreadExecutor();
	private final PrintWriter writer;

	public LogExecutorService(Writer writer) {
		this.writer = new PrintWriter(writer);
	}

	public void stop() throws InterruptedException {
		try {
			exec.shutdown();
			exec.awaitTermination(TIMEOUT, UNIT);
		} finally {
			writer.close();
		}
	}
}

