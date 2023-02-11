package com.example.reservation.user;

import java.util.Set;

public class UserDto {

    private Long id;

    private final String nick;

    private final String password;

//    private boolean administrationAccess;

    private final Set<String> roles;

    public UserDto(String nick, String password, Set<String> roles) {
        this.nick = nick;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public String getPassword() {
        return password;
    }

    public Set<String> getRoles() {
        return roles;
    }
}