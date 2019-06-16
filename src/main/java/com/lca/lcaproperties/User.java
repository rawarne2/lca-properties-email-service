package com.lca.lcaproperties;

import org.springframework.stereotype.Component;

@Component
public class User {

    private String emailAddress;
    private String message;

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String setMessage(String message) {
        return this.message = message;
    }

    public String getMessage() {
        return message;
    }


}