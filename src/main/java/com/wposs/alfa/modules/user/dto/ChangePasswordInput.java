package com.wposs.alfa.modules.user.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangePasswordInput implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -771125977292743225L;
	
	@NotNull
	@NotBlank(message = "El campo -email- no puede ir vacio")
	String email;
	@NotNull
	@NotBlank(message = "El campo -password- no puede ir vacio")
	String newPassword;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "ChangePasswordInput [email=" + email + ", password=" + newPassword + "]";
	} 

}
