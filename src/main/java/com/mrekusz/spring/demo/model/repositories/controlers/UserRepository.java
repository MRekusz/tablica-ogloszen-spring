package com.mrekusz.spring.demo.model.repositories.controlers;

import com.mrekusz.spring.demo.model.repositories.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
    List<User> findAllByUsername(String username);



}
