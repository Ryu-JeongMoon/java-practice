package org.designpattern.behavior.mediator._01_before;

public class Gym {

  private CleaningService cleaningService;

  public void clean() {
    cleaningService.clean(this);
  }
}
