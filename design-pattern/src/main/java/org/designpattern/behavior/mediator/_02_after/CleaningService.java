package org.designpattern.behavior.mediator._02_after;

public class CleaningService {

  private final FrontDesk frontDesk = new FrontDesk();

  public void getTowers(Integer guestId, int numberOfTowers) {
    String roomNumber = this.frontDesk.getRoomNumberFor(guestId);
    System.out.println("provide " + numberOfTowers + " to " + roomNumber);
  }
}
