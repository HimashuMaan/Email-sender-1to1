package com.email.service;

import com.email.exception.EmailException;
import jakarta.mail.MessagingException;

import java.util.List;

public interface EmailService {

    public String sendEmail(List<String> to)
            throws EmailException, MessagingException;

}
