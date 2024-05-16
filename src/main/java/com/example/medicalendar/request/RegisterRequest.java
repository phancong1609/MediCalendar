package com.example.medicalendar.request;

public class RegisterRequest {
    String email ;
    String password;
    String repeatpassword;

    public RegisterRequest() {
    }

    public RegisterRequest(String email, String password, String repeatpassword) {
        this.email = email;
        this.password = password;
        this.repeatpassword = repeatpassword;
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

    public String getRepeatpassword() {
        return repeatpassword;
    }

    public void setRepeatpassword(String repeatpassword) {
        this.repeatpassword = repeatpassword;
    }
}
