package com.example.reservation.user;

import com.example.reservation.security.Role;
import com.example.reservation.security.UserRoleRepository;
import com.example.reservation.treatment.TreatmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final TreatmentRepository treatmentRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, TreatmentRepository treatmentRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.treatmentRepository = treatmentRepository;

        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registerUser(UserRegistrationDto registration) {
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastName(registration.getLastName());
        user.setMail(registration.getMail());
        user.setNick(registration.getNick());
        String passwordHash = passwordEncoder.encode(registration.getPassword());
        user.setPassword(passwordHash);
        List<UserRole> list = Collections.singletonList(new UserRole(user, Role.ROLE_USER));
        user.setRoles(new HashSet<>(list));
        userRepository.save(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAllWithoutAdminUser() {
        Authentication userName = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(userName);
        return userRepository.findAll()
                .stream()
                .filter(user -> !user.getNick().equals(userName.getName()))
                .collect(Collectors.toList());
    }

    @Transactional
    public void changePassword(String newPassword){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User currentUser = userRepository.findUserByNick(userName);
        String newPasswordHash = passwordEncoder.encode(newPassword);
        currentUser.setPassword(newPasswordHash);
    }
}