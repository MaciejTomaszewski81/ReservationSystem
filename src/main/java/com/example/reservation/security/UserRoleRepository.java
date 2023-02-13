package com.example.reservation.security;

import com.example.reservation.user.User;
import com.example.reservation.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    @Transactional
    List<UserRole> deleteByUser(User user);
}