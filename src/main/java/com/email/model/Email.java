package com.email.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Email {

    private String name;
    private String email;
    private String subject;
    private String message;
    private String companyName;
    private LocalDateTime timeStamp;
}
