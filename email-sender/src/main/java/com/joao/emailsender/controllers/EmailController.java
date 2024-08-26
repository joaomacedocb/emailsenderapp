package com.joao.emailsender.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joao.emailsender.dtos.EmailDto;
import com.joao.emailsender.dtos.EmailResponseDto;
import com.joao.emailsender.models.EmailModel;
import com.joao.emailsender.services.EmailService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmailController {
    
    @Autowired
    EmailService emailService;
    
    @PostMapping("/send")
    public ResponseEntity<EmailResponseDto> sendingEmail(@RequestBody @Valid EmailDto emailDto) {
        EmailModel emailModel = new EmailModel();
        BeanUtils.copyProperties(emailDto, emailModel);
        emailService.sendEmail(emailModel);

        EmailResponseDto emailResponseDto = new EmailResponseDto();
        BeanUtils.copyProperties(emailModel, emailResponseDto);

        return new ResponseEntity<>(emailResponseDto, HttpStatus.CREATED);
    }
    
    @GetMapping("/emails")
    public ResponseEntity<List<EmailResponseDto>> getAllEmails() {
        List<EmailModel> emails = emailService.findAllEmails();

        if (emails.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<EmailResponseDto> emailResponseDtos = emails.stream().map(email -> {
            EmailResponseDto dto = new EmailResponseDto();
            BeanUtils.copyProperties(email, dto);
            return dto;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(emailResponseDtos, HttpStatus.OK);
    }
    

}
