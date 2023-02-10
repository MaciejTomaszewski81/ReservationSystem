package com.example.reservation.user;

import com.example.reservation.security.Role;
import com.example.reservation.security.UserRoleRepository;
import com.example.reservation.treatment.TreatmentRepository;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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

    public User addUser(User user){
    return userRepository.save(user);
    }

    public List<User>findAll(){
        return userRepository.findAll();
    }

//    public List<Treatment>findAll()
    public Optional<UserDto>findUserByNick(String nick){
        return userRepository.findByNick(nick)
                .map(UserConverterToUserDto::map);
    }

//    List<String>findUserByRole(){
//        return userRepository.findUsersByRoles("ROLE_ADMIN")
//                .stream()
//                .map(User::getRoles)
//                .map(Enum::name)
//                .toList();
//    }
    public void deleteUserByNick(String nick){
        userRepository.deleteUserByNick(nick);
    }

    @Transactional
    public void registerUser(UserRegistrationDto registration){
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

}