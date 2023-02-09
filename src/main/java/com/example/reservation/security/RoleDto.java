package com.example.reservation.security;

import com.example.reservation.user.User;
import com.example.reservation.user.UserDto;
import com.example.reservation.user.UserRepository;
import com.example.reservation.user.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

import static com.example.reservation.security.Role.ROLE_ADMIN;
import static com.example.reservation.security.Role.ROLE_USER;

@Component
public class RoleDto {
    private UserRepository userRepository;

    private UserRoleRepository userRoleRepository;

    public RoleDto(UserRepository userRepository, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
    }


//    public UserDto userToDto(User user){
//        return new UserDto(user.getId(), user.getNick(), user.getPassword(), userIsAdmin(user));
//    }
//
//    public void saveRoleForUser(UserDto userDto) {
//        Optional<User> optionalUser = userRepository.findById(userDto.getId());
//        if (optionalUser.isPresent()) {
//            User user = optionalUser.get();
//            setRoleForUser(user, userDto.isAdministrationAccess());
//        }
//    }

    @Transactional
    public void setRoleForUser(User user, boolean isAdministratorAcces) {
        userRoleRepository.deleteByUser(user);
        if (isAdministratorAcces) {
            UserRole userRole = new UserRole(user, ROLE_USER);
            UserRole adminRole = new UserRole(user, ROLE_ADMIN);
            userRoleRepository.save(userRole);
            userRoleRepository.save(adminRole);
        } else {
            UserRole userRole = new UserRole(user, ROLE_USER);
            userRoleRepository.save(userRole);
        }
    }

    private boolean userIsAdmin(User user) {
        Set<UserRole> roles = user.getRoles();
        boolean match = roles.stream()
                .anyMatch(userRole -> userRole.getRole().name().equals(ROLE_ADMIN.name()));
            return match;

    }

}
