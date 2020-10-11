package com.thiagowill.LandingPageGoMusic.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thiagowill.LandingPageGoMusic.models.Contato;
import com.thiagowill.LandingPageGoMusic.services.ContatoService;

@Controller
public class ViewController {
	
	@Autowired
	private ContatoService contatoService;


	@GetMapping(value = "/")
	public ModelAndView view() {
		Contato contato = new Contato();	
		ModelAndView mv = new ModelAndView("Index");
		mv.addObject("contato",contato);
		return mv;
	}
	
	@PostMapping(value = "/")
	public String cadastrar(@Valid Contato contato,BindingResult result , RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("message","preencha todos os campos!");
			return "redirect:/";
		}	
		try {
			contatoService.save(contato);
		}catch( Exception e) {
			attributes.addFlashAttribute("message",e.getMessage());
		}
		
		return "redirect:/thanks";
	}
	
	@GetMapping(value = "/thanks")
	public ModelAndView thanksView() {	
		ModelAndView mv = new ModelAndView("thankYouPage");
		return mv;
	}
}
