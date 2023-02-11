package com.example.reservation.user;

import java.util.Set;
import java.util.stream.Collectors;

public class UserConverterToUserDto {

    static UserDto map(User user) {
        String nick = user.getNick();
        String pass = user.getPassword();
        Set<String> roles = user.getRoles()
                .stream()
                .map(UserRole::getRole)
                .map(Enum::name)
                .collect(Collectors.toSet());
        return new UserDto(nick, pass, roles);
    }

}