package com.thiagowill.LandingPageGoMusic.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	public String sendMail(String msg, String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Aqui está seu ebook!");
        message.setText(msg);
        message.setTo(email);
        message.setFrom("thiagopompeu19@gmail.com");

        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
    }
	
}
