package org.designpattern.structure.facade._02_after;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public record EmailSender(EmailSettings emailSettings) {

  public void sendEmail(EmailMessage emailMessage) {
    JavaMailSender mailSender = new JavaMailSenderImpl();

    Properties properties = System.getProperties();
    properties.setProperty("mail.smtp.host", emailSettings.host());
    Session session = Session.getDefaultInstance(properties);

    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(emailMessage.from()));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailMessage.to()));
      message.addRecipient(Message.RecipientType.CC, new InternetAddress(emailMessage.cc()));
      message.setSubject(emailMessage.subject());
      message.setText(emailMessage.text());

      mailSender.send(message);
    } catch (MessagingException e) {
      System.out.println("e = " + e);
    }
  }
}
