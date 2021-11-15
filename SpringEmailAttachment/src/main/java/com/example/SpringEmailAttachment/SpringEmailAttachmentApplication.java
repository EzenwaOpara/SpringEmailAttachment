package com.example.SpringEmailAttachment;

import com.example.SpringEmailAttachment.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEmailAttachmentApplication {

	@Autowired
	SendEmailService sendEmailService;

	public static void main(String[] args) {
		SpringApplication.run(SpringEmailAttachmentApplication.class, args);
	}

}
