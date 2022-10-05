package org.designpattern.behavior.mediator._01_before;

public class Guest {

  private final Restaurant restaurant = new Restaurant();

  private final CleaningService cleaningService = new CleaningService();

  public void dinner() {
    restaurant.dinner(this);
  }

  public void getTowel(int numberOfTowel) {
    cleaningService.getTowel(this, numberOfTowel);
  }

}
