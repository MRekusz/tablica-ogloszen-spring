package com.mrekusz.spring.demo.model.repositories.controlers;


import com.mrekusz.spring.demo.model.repositories.entities.Advert;
import com.mrekusz.spring.demo.model.repositories.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class AdvertController {

    private static final Logger log = LoggerFactory.getLogger(AdvertController.class);
    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    @Autowired
    public AdvertController(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @PostMapping("/add-advert")
    public String addAvdert(String title, String description, Principal principal) {
        String username = principal.getName();
        User user = userRepository.findByUsername(username);

        Advert advert = new Advert();
        advert.setTitle(title);
        advert.setDescription(description);
        advert.setOwner(user);


        log.info("Próba zapisu ogłoszenia: " + advert);
        advert = advertRepository.save(advert);
        log.info("Zapisano ogłoszenie: " + advert);

        return "redirect:/";
    }


}
