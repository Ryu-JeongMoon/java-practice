package org.designpattern.behavior.state._01_before;

public class Client {

	public static void main(String[] args) {
		Student panda = new Student("panda");
		OnlineCourse onlineCourse = new OnlineCourse();

		Student bear = new Student("bear");
		bear.addPrivateCourse(onlineCourse);

		onlineCourse.addStudent(panda);
		onlineCourse.changeState(OnlineCourse.State.PRIVATE);

		onlineCourse.addStudent(bear);

		onlineCourse.addReview("hello", panda);

		System.out.println(onlineCourse.getState());
		System.out.println(onlineCourse.getStudents());
		System.out.println(onlineCourse.getReviews());
	}
}
