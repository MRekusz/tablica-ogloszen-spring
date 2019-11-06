package com.mrekusz.spring.demo.model.repositories;

import com.mrekusz.spring.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}
