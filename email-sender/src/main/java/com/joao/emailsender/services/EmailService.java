package com.joao.emailsender.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.joao.emailsender.enums.StatusEmail;
import com.joao.emailsender.models.EmailModel;
import com.joao.emailsender.repositories.EmailRepository;

import jakarta.transaction.Transactional;

@Service
public class EmailService {
	
	@Autowired
	EmailRepository emailRepository;
	
	@Autowired
	private JavaMailSender emailSender;

    @Transactional
    public EmailModel sendEmail(EmailModel emailModel) {
        emailModel.setSendDateEmail(LocalDateTime.now());
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            emailSender.send(message);

            emailModel.setStatusEmail(StatusEmail.SENT);
        } catch (MailException e){
            emailModel.setStatusEmail(StatusEmail.ERROR);
        } 
            return emailRepository.save(emailModel);
    }
    
    public List<EmailModel> findAllEmails() {
    	return emailRepository.findAll();
    }

}
