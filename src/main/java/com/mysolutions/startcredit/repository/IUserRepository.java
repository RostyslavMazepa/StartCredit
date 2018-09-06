package com.mysolutions.startcredit.repository;


import com.mysolutions.startcredit.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
