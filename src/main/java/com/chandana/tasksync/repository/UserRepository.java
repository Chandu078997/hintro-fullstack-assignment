package com.chandana.tasksync.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chandana.tasksync.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
