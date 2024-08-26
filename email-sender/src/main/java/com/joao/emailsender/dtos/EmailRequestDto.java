package com.joao.emailsender.dtos;

import jakarta.validation.constraints.NotBlank;

public class EmailRequestDto {
	
	@NotBlank
	private String ownerRef;

	public String getOwnerRef() {
		return ownerRef;
	}

	public void setOwnerRef(String ownerRef) {
		this.ownerRef = ownerRef;
	}
	
	

}
