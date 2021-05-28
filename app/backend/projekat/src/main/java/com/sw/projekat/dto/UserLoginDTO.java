package com.sw.projekat.dto;

// DTO za login
public class UserLoginDTO {

    private String username;
    private String password;

    public UserLoginDTO() {
        super();
    }

    public UserLoginDTO(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
