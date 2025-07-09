package com.email.sender;

import java.io.File;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.email.response.EmailResponse;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;

	public EmailResponse sendEmail(String from, List<String> toHr, String subject, String text, String attachmentPath)
			throws MessagingException {
		int count = 0;
		for (String to : toHr) {

			MimeMessage message = mailSender.createMimeMessage();
			// Enable multi-part message
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			// Set email properties

			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(text);
			FileSystemResource file = new FileSystemResource(new File(attachmentPath));
			helper.addAttachment(Objects.requireNonNull(file.getFilename()), file);

			mailSender.send(message);
			count++;
		}

		System.out.println("********************************************************************************" + count);
		EmailResponse response = new EmailResponse();
		response.setFrom(from);
		response.setSubject(subject);
		response.setText(text);
		return response;

	}

}