package com.email.controller;

import com.email.exception.EmailException;
import com.email.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/email/")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendMail(@RequestParam("to") String to) throws MessagingException {
        String email;
       try {
            List<String> toList = Arrays.asList(to.split(","));
            email = emailService.sendEmail(toList);
        } catch (EmailException | MessagingException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(email, HttpStatus.OK);
    }

}
