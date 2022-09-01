package org.designpattern.structure.facade._02_after;

import lombok.Builder;

public record EmailMessage(String from, String to, String cc, String bcc, String subject, String text) {

  @Builder
  public EmailMessage {
  }
}
