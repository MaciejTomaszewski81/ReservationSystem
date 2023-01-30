package com.example.reservation.user;

import java.util.Set;

public class UserDto {

    private final String mail;
    private final String password;
    private final Set<UserRole>roles;

    public UserDto(String mail, String password, Set<UserRole> roles) {
        this.mail = mail;
        this.password = password;
        this.roles = roles;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public Set<UserRole> getRoles() {
        return roles;
    }
}
