package com.joao.simplehelpdesk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.joao.emailsender.enums.StatusEmail;
import com.joao.emailsender.models.EmailModel;
import com.joao.emailsender.services.EmailService;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    private EmailService emailService;
    
    @Test
    public void testSendEmail() {
        EmailModel email = new EmailModel();
        email.setEmailFrom("empresatestes677@gmail.com");
        email.setEmailTo("joaomacedocb@gmail.com");
        email.setSubject("Test Email");
        email.setText("This is a test email.");
        
        EmailModel result = emailService.sendEmail(email);
        
        assertEquals(StatusEmail.SENT, result.getStatusEmail());
    }
}

