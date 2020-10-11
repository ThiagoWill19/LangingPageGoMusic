package com.thiagowill.LandingPageGoMusic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import com.thiagowill.LandingPageGoMusic.models.Contato;

@Controller
public interface ContatoRepository extends JpaRepository<Contato, Integer>{

}
