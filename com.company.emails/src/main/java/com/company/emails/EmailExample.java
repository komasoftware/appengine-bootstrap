package com.company.emails;

/**
 * Interface to interact with the email service
 */
public interface EmailExample {

    /**
     * Sends a test email
     *
     * @param emailAddress the email address to send the email to
     */
    public void sendTestEmail(String emailAddress);
}
