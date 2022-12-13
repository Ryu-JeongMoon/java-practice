package org.eternity.billing.step03;

import java.time.Duration;
import java.time.LocalDateTime;

public record Call(LocalDateTime from, LocalDateTime to) {

	public Duration getDuration() {
		return Duration.between(from, to);
	}
}
