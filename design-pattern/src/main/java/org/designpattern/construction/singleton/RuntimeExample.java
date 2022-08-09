package org.designpattern.construction.singleton;

public class RuntimeExample {

	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		System.out.println("Available processors: " + runtime.availableProcessors());
		System.out.println("Free memory: " + runtime.freeMemory());
		System.out.println("Total memory: " + runtime.totalMemory());
	}
}

/*
Runtime은 static field 싱글턴 사용
 */