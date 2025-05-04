package com.email.controller;

import com.email.model.EmailRequest;
import com.email.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @GetMapping("/home")
    public String welcome(){
        return "Hello this is just for testing";
    }

    @PostMapping("/sendemail")
    public ResponseEntity<?> sendMessage(@RequestBody EmailRequest request){
        System.out.println(request);
        boolean result =  this.emailService.sendEmail(request.getSubject(),request.getMessage(),request.getTo());
        if(result){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("Email send successfully");
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email not send....");
        }

    }
}
