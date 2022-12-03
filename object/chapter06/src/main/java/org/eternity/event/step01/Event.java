package org.eternity.event.step01;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event {

	private final String subject;
	private LocalDateTime from;
	private Duration duration;

	public Event(String subject, LocalDateTime from, Duration duration) {
		this.subject = subject;
		this.from = from;
		this.duration = duration;
	}

	public boolean isSatisfied(RecurringSchedule schedule) {
		boolean isSatisfied = from.getDayOfWeek() == schedule.dayOfWeek()
			&& from.toLocalTime().equals(schedule.from())
			&& duration.equals(schedule.duration());

		if (!isSatisfied) {
			reschedule(schedule);
		}

		return isSatisfied;
	}

	private void reschedule(RecurringSchedule schedule) {
		from = LocalDateTime.of(from.toLocalDate().plusDays(daysDistance(schedule)), schedule.from());
		duration = schedule.duration();
	}

	private long daysDistance(RecurringSchedule schedule) {
		return schedule.dayOfWeek().getValue() - from.getDayOfWeek().getValue();
	}
}
