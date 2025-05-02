package com.email.service;

import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailService {

    public void sendEmail(String subject, String message, String to){
        // rest of the code...

        // variable for gmail
        String host = "smtp.gmail.com";

        // get the system properties
        Properties properties = System.getProperties();
        System.out.println("PROPERTIES "+properties);

        // setting import information to properties object

        // host set
        properties.put("mail.smtp.host",host);
        properties.put("mail.smtp.port","465");
        properties.put("mail.smtp.ssl.enable","true");
        properties.put("mail.smtp.auth","true");
    }
}
