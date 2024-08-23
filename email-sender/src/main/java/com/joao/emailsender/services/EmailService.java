package com.joao.emailsender.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.emailsender.repositories.EmailRepository;

@Service
public class EmailService {
	
	@Autowired
	EmailRepository emailRepository;

}
