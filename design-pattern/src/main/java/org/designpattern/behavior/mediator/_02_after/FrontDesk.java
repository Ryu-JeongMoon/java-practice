package org.designpattern.behavior.mediator._02_after;

import java.time.LocalDateTime;

public class FrontDesk {

  private final CleaningService cleaningService = new CleaningService();

  private final Restaurant restaurant = new Restaurant();

  public void getTowels(Guest guest, int numberOfTowels) {
    cleaningService.getTowers(guest.getId(), numberOfTowels);
  }

  public String getRoomNumberFor(Integer guestId) {
    return "1111";
  }

  public void dinner(Guest guest, LocalDateTime dateTime) {
    restaurant.dinner(guest.getId(), dateTime);
  }
}
