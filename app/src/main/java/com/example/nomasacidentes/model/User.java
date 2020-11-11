package com.example.nomasacidentes.model;


public class User {

    private String email;
    private String username;
    private String password;


    private String token;



    public User(
            String email,
            String username,
            String password,
            String token
    ) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.token = token;
    }



    public String getToken(){
        return token;
    }
    public String getUsername(){
        return username;
    }




}