package org.eternity.movie.step05;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

	private final DiscountConditionType type;

	private int sequence;

	private DayOfWeek dayOfWeek;
	private LocalTime startTime;
	private LocalTime endTime;

	public DiscountCondition(int sequence) {
		this.type = DiscountConditionType.SEQUENCE;
		this.sequence = sequence;
	}

	public DiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.type = DiscountConditionType.PERIOD;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public boolean isDiscountable(Screening screening) {
		if (type == DiscountConditionType.PERIOD) {
			return isSatisfiedByPeriod(screening);
		}

		return isSatisfiedBySequence(screening);
	}

	private boolean isSatisfiedByPeriod(Screening screening) {
		return screening.whenScreened().getDayOfWeek().equals(dayOfWeek)
			&& !startTime.isAfter(screening.whenScreened().toLocalTime())
			&& !endTime.isBefore(screening.whenScreened().toLocalTime());
	}

	private boolean isSatisfiedBySequence(Screening screening) {
		return sequence == screening.sequence();
	}
}
