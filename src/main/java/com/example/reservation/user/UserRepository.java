package com.example.reservation.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByNick(String nick);

    User findUserByNick(String nick);

    List<User> findUsersByRoles(String name);

    void deleteUserByNick(String nick);

}