package org.designpattern.behavior.state._02_after;

public record Private(OnlineCourse onlineCourse) implements State {

	@Override
	public void addReview(String review, Student student) {
		if (onlineCourse.getStudents().contains(student)) {
			onlineCourse.getReviews().add(review);
		} else {
			throw new UnsupportedOperationException("프라이빗 코스를 수강하는 학생만 리뷰를 남길 수 있습니다.");
		}
	}

	@Override
	public void addStudent(Student student) {
		if (student.isAvailable(onlineCourse)) {
			onlineCourse.getStudents().add(student);
		} else {
			throw new UnsupportedOperationException("프라이빛 코스를 수강할 수 없습니다.");
		}
	}
}
