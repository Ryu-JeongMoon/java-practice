package com.example.javaanything.jmh;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime) // 벤치마크 대상 메소드를 실행하는 데 걸린 평균 시간 측정
@OutputTimeUnit(TimeUnit.MILLISECONDS) // 벤치마크 결과를 밀리초 단위로 출력
@Fork(value = 2, jvmArgs = { "-Xms4G", "-Xmx4G" }) // 4Gb의 힙 공간을 제공한 환경에서 두 번 벤치마크를 수행해 결과의 신뢰성 확보
public class CompletableFutureTest {

  @Benchmark
  public void streamWithAddAll() {
    List<CompletableFuture<Void>> stream1 = new java.util.ArrayList<>(IntStream.range(0, 10)
      .mapToObj(estimate -> CompletableFuture.runAsync(() -> System.out.println("estimate = " + estimate)))
      .toList());

    List<CompletableFuture<Void>> stream2 = IntStream.range(11, 20)
      .mapToObj(estimate -> CompletableFuture.runAsync(() -> System.out.println("estimate = " + estimate)))
      .toList();

    stream1.addAll(stream2);

    CompletableFuture.allOf(stream1.toArray(new CompletableFuture[0]))
      .thenRun(() -> System.out.println("all done"))
      .join();
  }
}
