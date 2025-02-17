package com.example.email.project;

import com.example.email.project.services.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
public class EmailSenderTest {

    @Autowired
    private EmailService emailService;

    @Test
    void emailSendTest(){
        System.out.println("sending email");
        emailService.sendEmail("pathakmanas111@gmail.com","Emil from spring boot","This email is send using springboot while creating email service");
    }

    @Test
    void sendHtmlInEmail(){
        String html ="" +
                "<h1 style ='color: red; border: 1px solid red;'> welcome to learn spring boot tutorial to make emaail service </h1>"+
                "";
        emailService.sendEmailWithHtml("pathakmanas111@gmail.com","Email from sprig boot",html);
    }

    @Test
    void sendEmailWithFile(){
        emailService.sendEmailWithFile("pathakmanas111@gmail.com","Email with file", "this email contains file",new File(
                "/Users/manaspathak/Downloads/email-project/src/main/resources/static/images/1738903932628.jpg"));
    }

    @Test
    void sendEmailWithFileWithStream(){
        File file= new File("/Users/manaspathak/Downloads/email-project/src/main/resources/static/images/1738903932628.jpg");
        try {
            InputStream is =new FileInputStream(file);
            emailService.sendEmailWithFile("pathakmanas111@gmail.com","Email with file", "this email contains file",is);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}