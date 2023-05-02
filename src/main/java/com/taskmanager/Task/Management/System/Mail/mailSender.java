package com.taskmanager.Task.Management.System.Mail;

public class mailSender {

    private String email;
    private String password;
    private String subject;
    private String body;
    private String fName;


    public mailSender(String email, String password, String subject, String body, String fName) {
        this.email = email;
        this.password = password;
        this.subject = subject;
        this.body = body;
        this.fName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
