package eapli.base.productOrderManagement.domain;

import eapli.framework.domain.model.ValueObject;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.Embeddable;
import java.util.Properties;

/**
 * The type Notification.
 */
@Embeddable
public class Notification implements ValueObject {

    private String subject;
    private String message;

    /**
     * Instantiates a new Notification.
     */
    protected Notification() {
        // ORM
    }

    /**
     * Instantiates a new Notification.
     *
     * @param recieverEmail the reciever email
     * @param subject       the subject
     * @param message       the message
     */
    public Notification(String recieverEmail, String subject, String message) {

        try {
            sendEmail(recieverEmail, subject, message);
            this.subject = subject;
            this.message = message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static Message prepareMessage(Session session, String ownEmail, String receiverEmail, String subject, String messageContent) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(ownEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
            message.setSubject(subject);
            message.setText(messageContent);
            return message;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    private void sendEmail(String receiverEmail, String subject, String message) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String ownEmail = "g03lapr4@gmail.com";
        String ownPass = "grupo3@s";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(ownEmail, ownPass);
            }
        });
        Message messageToSend = prepareMessage(session, ownEmail, receiverEmail, subject, message);
        Transport.send(messageToSend);
    }
}
