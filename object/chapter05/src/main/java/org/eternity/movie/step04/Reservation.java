package org.eternity.movie.step04;

import org.eternity.money.Money;

public record Reservation(Customer customer, Screening screening, Money fee, int audienceCount) {

}
