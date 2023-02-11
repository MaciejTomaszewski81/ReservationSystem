package com.example.reservation.security;

import com.example.reservation.user.*;
import jakarta.transaction.Transactional;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//  private UserService userService;
//
//    public MyUserDetailsService(UserService userService) {
//        this.userService = userService;
//    }

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String nick) throws UsernameNotFoundException {

//        return userService.findUserByNick(nick)
//                .map(this::createUserDetails)
//                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with nick %s not found", nick)));
//
//    }
//
//    private UserDetails createUserDetails(UserDto details){
//    return User.builder()
//            .username(details.getNick())
//            .username(details.getPassword())
//            .roles()
//            .build();
//    }
//}
        User user = userRepository.findUserByNick(nick);
        if (user == null)
            throw new UsernameNotFoundException("User not found");
        org.springframework.security.core.userdetails.User userDetails =
                new org.springframework.security.core.userdetails.User(
                        user.getNick(),
                        user.getPassword(),
                        convertAuthorities(user.getRoles()));
        return userDetails;
    }

    private Set<GrantedAuthority> convertAuthorities(Set<UserRole> roles) {
        Set<GrantedAuthority> authorities = new HashSet<>();
        for (UserRole user : roles) {
            authorities.add(new SimpleGrantedAuthority(user.getRole().name()));
        }
        return authorities;
    }
}