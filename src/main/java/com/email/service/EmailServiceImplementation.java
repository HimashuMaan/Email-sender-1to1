package com.email.service;

import com.email.exception.EmailException;
import com.email.response.EmailResponse;
import com.email.sender.EmailSender;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImplementation implements EmailService {

    @Autowired
    private EmailSender emailSender;

    @Value("${spring.mail.username}")
    private String email;


    @Override
    public String sendEmail(List<String> to)
            throws EmailException, MessagingException {

        String subject = "Application for Java Developer, Immediate Joiner with 2.5 Years Experience";
        String body = "Hi Team,"+"\n"+"\n"+
        "I hope this email finds you well. My name is Himanshu, and I am writing to express my keen interest in the Java Developer role. "+
                "With 2.5 years of experience in Java development—particularly in Java, Spring Boot, and Microservices—and immediate availability to join, I believe I can contribute effectively to your team."+"\n"+"\n"+

        " Over the past year, I have been actively involved in Java programming, gaining valuable experience in developing"+
        "and maintaining applications using Java, object - oriented design principles, and"+
        " agile development methodologies.My time as a Java developer has allowed me to build strong problem - solving"+
        " abilities and collaborate effectively in dynamic team environments."+"\n"+"\n"+

        "I have attached my updated resume, which outlines my educational background, work experience, and"+
        " notable projects I have contributed too."+"\n"+

        " Thank you for considering my application.I look forward to the opportunity to speak with you further."+"\n"+

        "Sincerely,"+"\n"+"\n"+

        "Himanshu"+"\n"+
        "Phone: 9588954983"+"\n"+
        " Email: himanshu.rajroxx@gmail.com "+"\n"+
        "LinkedIn: https://www.linkedin.com/in/himanshu-89b652148/";

        String attachment = "E:/project/Himanshu java developer_Resume.pdf";


        EmailResponse response = emailSender.sendEmail(email, to, subject, body, attachment);
        System.out.println(response);

        return "Email sent successfully !";
    }
}
