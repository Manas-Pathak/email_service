package com.example.email.project.services;

import java.io.File;
import java.io.InputStream;

public interface EmailService {


    //send email to single person
    void sendEmail(String to, String subject,String message);

    //send email to multiple person
    void sendEmail(String[] to,String subject, String message);


    //Send email with html
    void sendEmailWithHtml(String to, String subject, String htmlContent);



    //send email with file
    void sendEmailWithFile(String to, String subject, String message, File file);

    //send file with input stream
    void sendEmailWithFile(String to, String subject, String message, InputStream is);
}
