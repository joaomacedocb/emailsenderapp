package com.joao.emailsender.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.joao.emailsender.enums.StatusEmail;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emails")
public class EmailModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer emailId;
    
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    
    @Column(columnDefinition = "TEXT")
    private String text;
    
    private LocalDateTime sendDateEmail;
    private StatusEmail statusEmail;
    
	
}
