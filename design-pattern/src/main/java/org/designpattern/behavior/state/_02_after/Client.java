package org.designpattern.behavior.state._02_after;

public class Client {

	public static void main(String[] args) {
		OnlineCourse onlineCourse = new OnlineCourse();
		Student panda = new Student("panda");
		Student bear = new Student("bear");

		bear.addPrivate(onlineCourse);
		onlineCourse.addStudent(panda);

		onlineCourse.changeState(new Private(onlineCourse));
		onlineCourse.addReview("hello", panda);

		onlineCourse.addStudent(bear);

		System.out.println(onlineCourse.getState());
		System.out.println(onlineCourse.getReviews());
		System.out.println(onlineCourse.getStudents());
	}
}
