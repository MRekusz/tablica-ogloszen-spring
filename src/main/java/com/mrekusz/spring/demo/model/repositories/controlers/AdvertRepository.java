package com.mrekusz.spring.demo.model.repositories.controlers;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mrekusz.spring.demo.model.repositories.entities.Advert;

import java.util.List;


public interface AdvertRepository extends JpaRepository <Advert, Long>{

    List<Advert> findAllByOrderByPostedDesc();


}
