package com.thiagowill.LandingPageGoMusic.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagowill.LandingPageGoMusic.exceptions.EmailAlreadyRegistered;
import com.thiagowill.LandingPageGoMusic.models.Contato;
import com.thiagowill.LandingPageGoMusic.repositories.ContatoRepository;

@Service
public class ContatoService {

	@Autowired
	private ContatoRepository contatoRepository;
	@Autowired
	private EmailService emailService;
	
	public void save(Contato contato)throws Exception{
		if(!emailVerification(contato)) throw new EmailAlreadyRegistered();
		else contatoRepository.save(contato);
		emailService.sendMail("Ebook Violão Básico", contato.getEmail());
		
		
	}
	
	public List<Contato> findAll() {
		return contatoRepository.findAll();
	}
	
	
	public boolean emailVerification(Contato contato) {
		for(Contato c : findAll()) {
			if(c.getEmail().equals(contato.getEmail()))return false;
		}
		return true;
	}
}
