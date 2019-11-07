package com.mrekusz.spring.demo.model.repositories.controlers;


import com.mrekusz.spring.demo.model.repositories.entities.Advert;
import com.mrekusz.spring.demo.model.repositories.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user-adverts")
public class UserAdvertsController {

    private static final Logger log = LoggerFactory.getLogger(AdvertController.class);

    private final UserRepository userRepository;
    private final AdvertRepository advertRepository;

    @Autowired
    public UserAdvertsController(UserRepository userRepository, AdvertRepository advertRepository) {
        this.userRepository = userRepository;
        this.advertRepository = advertRepository;
    }

    @GetMapping
    public String AdvertRepository(Model model, Principal principal) {
        String username = principal.getName();
        List<Advert> advertsAddedByUser = advertRepository.findAllByOwner_UsernameOrderByPostedDesc(username);
        model.addAttribute("adverts", advertsAddedByUser);

//        User user = userRepository.findByUsername(username);
//        user.setUsername(username);

//        Advert advert = new Advert();
//        advert.setTitle(title);

//        log.info("Witaj użytkowniku " + user);
//        log.info("Twoje ogłoszenia " + advert);

        return "WEB-INF/views/user-adverts-page.jsp";
    }


}
