package com.mrekusz.spring.demo;

import com.mrekusz.spring.demo.model.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/register")
public class RegistrationController {

    private final UserRepository userRepository;
    PasswordEncoder passwordEncoder;


    @Autowired
    public RegistrationController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping
    public String prepareRegistrationPage() {
// definicja kontrolera
        return "/WEB-INF/views/views.jsp";
    }

    @PostMapping
    public String processRegistrationPage(String username, String password, String firstName, String lastName) {

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setActive(true);
        userRepository.save(user);
        String encodedPassword = passwordEncoder.encode(password);


        return "redirect:/index.html";
    }

}
