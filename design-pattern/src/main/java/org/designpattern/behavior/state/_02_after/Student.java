package org.designpattern.behavior.state._02_after;

import java.util.HashSet;
import java.util.Set;

public record Student(String name, Set<OnlineCourse> onlineCourses) {

	public Student(String name) {
		this(name, new HashSet<>());
	}

	public Student(String name, Set<OnlineCourse> onlineCourses) {
		this.name = name;
		this.onlineCourses = onlineCourses;
	}

	public boolean isAvailable(OnlineCourse onlineCourse) {
		return onlineCourses.contains(onlineCourse);
	}

	public void addPrivate(OnlineCourse onlineCourse) {
		this.onlineCourses.add(onlineCourse);
	}
}
