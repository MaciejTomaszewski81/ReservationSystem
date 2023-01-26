package com.example.reservation.user;

import com.example.reservation.treatment.TreatmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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
}