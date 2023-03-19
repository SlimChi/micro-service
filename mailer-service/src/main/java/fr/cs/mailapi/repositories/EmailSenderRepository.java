package fr.cs.mailapi.repositories;

/**
 * @author Slimane
 * @Project ApiEmail
 */
public interface EmailSenderRepository {
    public void sendEmail(String to, String subject, String message);
}
