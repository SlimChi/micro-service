package fr.cs.mailapi.service;

import fr.cs.mailapi.repositories.EmailSenderRepository;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author slimane
 * @Project emailSpring
 */

@Service
public class EmailSendService implements EmailSenderRepository {

    private final JavaMailSender javaMailSender;

    public EmailSendService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendEmail(String to, String subject, String message){
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("testmailcoolspring@gmail.com");
        simpleMessage.setTo(to);
        simpleMessage.setSubject(subject);
        simpleMessage.setText(message);
        javaMailSender.send(simpleMessage);
 }
}
