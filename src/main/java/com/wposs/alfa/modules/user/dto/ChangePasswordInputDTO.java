package com.wposs.alfa.modules.user.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChangePasswordInputDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -771125977292743225L;
	
	@NotNull
	@NotBlank(message = "El campo no puede ir vacio")
	String email;
	@NotNull
	@NotBlank(message = "El campo no puede ir vacio")
	String new_password;
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getNewPassword() {
		return new_password;
	}
	public void setNewPassword(String newPassword) {
		this.new_password = newPassword;
	}
	@Override
	public String toString() {
		return "ChangePasswordInput [email=" + email + ", password=" + new_password + "]";
	} 

}
