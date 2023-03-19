package fr.cs.mailapi.controller;


import fr.cs.mailapi.model.EmailMessage;
import fr.cs.mailapi.repositories.EmailSenderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Slimane
 * @Project ApiMAil
 */

@RestController
public class MailController {

    private final EmailSenderRepository emailSenderRepository;

    public MailController(EmailSenderRepository emailSenderRepository) {
        this.emailSenderRepository = emailSenderRepository;
    }


    @PostMapping("/mail")
    public ResponseEntity emailSending(@RequestBody EmailMessage emailMessage) {

        this.emailSenderRepository.sendEmail(emailMessage.getTo(), emailMessage.getSubject(), emailMessage.getMessage());
        return ResponseEntity.ok("Vous avez envoyez un email à : " + emailMessage.getTo());

    }

}
