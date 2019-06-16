package com.lca.lcaproperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
public class RegistrationController {

    @Autowired
    private MailService mailService;

    @Autowired
    private User user;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("send-mail") String emailRequest (@RequestBody String emailRequest) {

//        public String send () {


            this.user.setEmailAddress("lcallcproperties@gmail.com");
            this.user.setMessage(emailRequest);

            try {
                mailService.sendEmail(this.user);
            } catch (MailException mailException) {
                System.out.println(mailException);
            }
            return "Congratulations! Your mail has been send to the user.";
//        }
    }

    @RequestMapping("send-mail-attachment")
    public String sendWithAttachment() throws MessagingException {


        this.user.setEmailAddress("lcallcproperties@gmail.com"); //Receiver's email address


        try {
            mailService.sendEmailWithAttachment(this.user);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }
}
