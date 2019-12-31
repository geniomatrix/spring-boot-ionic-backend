package com.arcanjoweb.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.arcanjoweb.cursomc.domain.Pedido;

public interface EmailService {
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
