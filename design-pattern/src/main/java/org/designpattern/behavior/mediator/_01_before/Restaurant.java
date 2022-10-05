package org.designpattern.behavior.mediator._01_before;

public class Restaurant {

  private final CleaningService cleaningService = new CleaningService();

  public void dinner(Guest guest) {
    System.out.println("dinner " + guest);
  }

  public void clean() {
    cleaningService.clean(this);
  }
}
