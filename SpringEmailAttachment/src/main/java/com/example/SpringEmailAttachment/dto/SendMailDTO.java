package com.example.SpringEmailAttachment.dto;

import java.io.Serializable;
import java.util.ArrayList;

public class SendMailDTO implements Serializable {

    private String fromEmail;
    private String toEmail;
    private String subject;
    private String body;
    private ArrayList<String> attachments = new ArrayList<>();
    private boolean isSent;

    public String getFromEmail() {
        return fromEmail;
    }

    public void setFromEmail(String fromEmail) {
        this.fromEmail = fromEmail;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public ArrayList<String> getAttachments() {
        return attachments;
    }

    public void setAttachments(ArrayList<String> attachments) {
        this.attachments = attachments;
    }

    public boolean isSent() {
        return isSent;
    }

    public void setSent(boolean sent) {
        isSent = sent;
    }

    @Override
    public String toString() {
        return "SendMailDTO{" +
                "fromEmail='" + fromEmail + '\'' +
                ", toEmail='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                ", attachments=" + attachments +
                ", isSent=" + isSent +
                '}';
    }
}
