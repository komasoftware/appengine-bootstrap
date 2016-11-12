package com.company.emails.impl;

import com.company.emails.EmailExample;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Implementation of the {@link EmailExample}
 */
public class EmailExampleImpl implements EmailExample {

    /**
     * Don't forget to update the from email address with your app id
     * see https://cloud.google.com/appengine/docs/java/mail/
     *
     * @param emailAddress the email address to send the email to
     */
    @Override
    public void sendTestEmail(String emailAddress) {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        String msgBody = "This is the body of my message";

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress("noreply@<your app id>.appspotmail.com", "Company Name"));
            msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailAddress, "Mr/Ms Something"));
            msg.setSubject("Your [company name] account has been activated");
            msg.setText(msgBody);
            Transport.send(msg);
        } catch (Exception e) {
            //TODO: Do some error handling here
        }
    }
}
