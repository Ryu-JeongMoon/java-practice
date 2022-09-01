package org.designpattern.structure.facade._02_after;

public class Client {

  public static void main(String[] args) {
    EmailSettings emailSettings = new EmailSettings("127.0.0.1");

    EmailSender emailSender = new EmailSender(emailSettings);

    EmailMessage emailMessage1 = new EmailMessage(
      "panda", "bear", "일남", "Empty CC", "오징어게임", "오징어게임은 재밌다."
    );

    EmailMessage emailMessage2 = EmailMessage.builder()
      .from("panda")
      .to("bear")
      .cc("일남")
      .bcc("Empty CC")
      .subject("오징어게임")
      .text("오징어게임은 재밌다.")
      .build();

    emailSender.sendEmail(emailMessage1);
    emailSender.sendEmail(emailMessage2);
  }
}
