package com.joao.emailsender.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EmailDto {
	
	@NotBlank
	private String ownerRef;
	@NotBlank
	private String emailFrom;
	@Email
	@NotBlank
	private String emailTo;
	@NotBlank
	private String subject;
	@NotBlank
	private String text;


}
