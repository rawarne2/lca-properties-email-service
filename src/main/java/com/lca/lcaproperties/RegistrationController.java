package com.lca.lcaproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegistrationController {

    @Autowired
    private MailService mailService;

    @Autowired
    private User user;

    @CrossOrigin(origins = { "http://localhost:4200", "https://lca-properties.herokuapp.com" })
    @PostMapping("send-mail") String emailRequest (@RequestBody String emailRequest) {
        System.out.print("starting email request");
        try {
            System.out.print("starting email request try");
            mailService.sendEmail(this.user, emailRequest);
            return "Congratulations! Your mail has been send to the user.";
        } catch (MailException mailException) {
            System.out.printf("Email failed to send with this exception: %s", mailException);
            return "Email request failed.";
        }
    }
}
