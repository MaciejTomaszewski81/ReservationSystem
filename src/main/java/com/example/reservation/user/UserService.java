package com.example.reservation.user;

import com.example.reservation.treatment.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TreatmentRepository treatmentRepository;

    public UserService(UserRepository userRepository, TreatmentRepository treatmentRepository) {
        this.userRepository = userRepository;
        this.treatmentRepository = treatmentRepository;
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

}