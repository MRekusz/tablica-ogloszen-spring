package com.mrekusz.spring.demo.model.repositories.controlers;

import com.mrekusz.spring.demo.model.repositories.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
