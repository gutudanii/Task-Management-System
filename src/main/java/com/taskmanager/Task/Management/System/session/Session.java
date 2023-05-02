package com.taskmanager.Task.Management.System.session;

public class Session {

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Session(String username){
        this.username = username;
    }
}
