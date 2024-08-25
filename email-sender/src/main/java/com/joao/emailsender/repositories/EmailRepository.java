package com.joao.emailsender.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joao.emailsender.models.EmailModel;

public interface EmailRepository extends JpaRepository<EmailModel, UUID> {

}
