package org.eternity.event.step01;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

public record RecurringSchedule(String subject, DayOfWeek dayOfWeek, LocalTime from, Duration duration) {

}
