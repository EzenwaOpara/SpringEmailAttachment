package com.example.SpringEmailAttachment.service;

import com.example.SpringEmailAttachment.dto.SendMailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class SendEmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendMailWithAttachment(SendMailDTO sendMailDTO) throws MessagingException, IOException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom(sendMailDTO.getFromEmail());
        mimeMessageHelper.setTo(sendMailDTO.getToEmail());
        mimeMessageHelper.setText(sendMailDTO.getBody());
        mimeMessageHelper.setSubject(sendMailDTO.getSubject());

        sendMailDTO.getAttachments().forEach(attachment -> {
            FileSystemResource fileSystemResource = new FileSystemResource(new File(attachment));
            try {
                mimeMessageHelper.addAttachment(Objects.requireNonNull(fileSystemResource.getFilename()),fileSystemResource);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });

        javaMailSender.send(mimeMessage);
    }
}
