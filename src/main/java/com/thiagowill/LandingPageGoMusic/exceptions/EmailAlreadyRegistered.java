package com.thiagowill.LandingPageGoMusic.exceptions;

public class EmailAlreadyRegistered extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public EmailAlreadyRegistered() {
		super("Email já registrado!");
		this.msg = "Email já registrado!";
	}
	
	public String getMessage() {
		return msg;
	}

}
