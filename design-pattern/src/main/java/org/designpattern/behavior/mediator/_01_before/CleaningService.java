package org.designpattern.behavior.mediator._01_before;

public class CleaningService {

  public void clean(Gym gym) {
    System.out.println("clean " + gym);
  }

  public void getTowel(Guest guest, int numberOfTowel) {
    System.out.println(numberOfTowel + " towers to " + guest);
  }

  public void clean(Restaurant restaurant) {
    System.out.println("clean " + restaurant);
  }
}
