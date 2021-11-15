package com.example.SpringEmailAttachment.rest;

import com.example.SpringEmailAttachment.dto.SendMailDTO;
import com.example.SpringEmailAttachment.service.SendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class SendEmailResource {

    @Autowired
    private SendEmailService sendEmailService;

    @PostMapping("/send-email")
    public ResponseEntity<SendMailDTO> sendEmailWithAttachment(@RequestBody SendMailDTO sendMailDTO) {

        try {
            sendEmailService.sendMailWithAttachment(sendMailDTO);
            sendMailDTO.setSent(true);
            System.out.println("Email successfully sent");
            return new ResponseEntity<>(sendMailDTO, HttpStatus.OK);
        } catch (MessagingException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
