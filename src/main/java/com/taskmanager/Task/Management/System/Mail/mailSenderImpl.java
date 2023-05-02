package com.taskmanager.Task.Management.System.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

@Service
public class mailSenderImpl implements mailSenderService {


    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void mailSender(String email, String name){
        String msg = "";
        MimeMessagePreparator mailMessage = mimeMessage -> {

            MimeMessageHelper message = new MimeMessageHelper(
                    mimeMessage, "utf-8");
                    message.setFrom("taskmanageralert@gmail.com","Task Alert");
                    message.setText(msg,true);
                    message.setSubject(name+"!, It is Time to Complete your project");
                    message.addTo(email);

        };
        this.javaMailSender.send(mailMessage);
    }

}

