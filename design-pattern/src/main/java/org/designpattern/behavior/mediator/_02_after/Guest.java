package org.designpattern.behavior.mediator._02_after;

import java.time.LocalDateTime;

public class Guest {

  private Integer id;

  private final FrontDesk frontDesk = new FrontDesk();

  public void getTowels(int numberOfTowels) {
    this.frontDesk.getTowels(this, numberOfTowels);
  }

  private void dinner(LocalDateTime dateTime) {
    this.frontDesk.dinner(this, dateTime);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
}
