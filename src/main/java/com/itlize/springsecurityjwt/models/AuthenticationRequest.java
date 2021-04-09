package com.itlize.springsecurityjwt.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class AuthenticationRequest {
   @Id
   @GeneratedValue
   @Column(name = "user_id")
   private Integer id;
   @Column(name ="user_name", nullable = false, unique = true)
    private String username;
    private String password;

    public AuthenticationRequest() {
    }

    public AuthenticationRequest(String userName, String password) {
        this.username = userName;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
