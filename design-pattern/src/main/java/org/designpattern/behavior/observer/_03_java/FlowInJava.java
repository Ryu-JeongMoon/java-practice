package org.designpattern.behavior.observer._03_java;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class FlowInJava {

	public static void main(String[] args) throws InterruptedException {
		try (SubmissionPublisher<String> publisher = new SubmissionPublisher<>()) {
			Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {

				private Flow.Subscription subscription;

				@Override
				public void onSubscribe(Flow.Subscription subscription) {
					System.out.println("FlowInJava.onSubscribe");
					this.subscription = subscription;
					this.subscription.request(1);
				}

				@Override
				public void onNext(String item) {
					// main-thread sleep 안 시키면 요 부분 출력이 안 될 때가 있듬
					System.out.println("FlowInJava.onNext");
					System.out.println("current thread : " + Thread.currentThread().getName());
					System.out.println(item);
				}

				@Override
				public void onError(Throwable throwable) {
				}

				@Override
				public void onComplete() {
					System.out.println("FlowInJava.onComplete");
				}
			};

			publisher.subscribe(subscriber);
			publisher.submit("hello java");
			System.out.println("비동기 실행 시 요놈이 먼저 출력될 수도 ~?");

			Thread.sleep(50);
		}
	}
}
