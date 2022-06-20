package com.wposs.alfa.modules.user.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

public class UpdatePasswordInput implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1402619971883767908L;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String token;
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String update_password;
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String old_password;
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String username;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getUpdate_password() {
		return update_password;
	}
	public void setUpdate_password(String update_password) {
		this.update_password = update_password;
	}	
	public String getOld_password() {
		return old_password;
	}
	public void setOld_password(String old_password) {
		this.old_password = old_password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "UpdatePasswordInputDTO [token=" + token + ", update_password=" + update_password + ", old_password="
				+ old_password + ", username=" + username + "]";
	}
	
	
}
