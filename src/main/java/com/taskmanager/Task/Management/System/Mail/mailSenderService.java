package com.taskmanager.Task.Management.System.Mail;

import org.springframework.stereotype.Service;

@Service
public interface mailSenderService {

    public void mailSender(String email,
                           String name);
}
