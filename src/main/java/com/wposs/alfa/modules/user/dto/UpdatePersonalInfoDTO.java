package com.wposs.alfa.modules.user.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class UpdatePersonalInfoDTO implements Serializable {

	private static final long serialVersionUID = -1464012193162224153L;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String username; 
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String names; 
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String surnames;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String personal_mail;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getPersonal_mail() {
		return personal_mail;
	}

	public void setPersonal_mail(String personal_mail) {
		this.personal_mail = personal_mail;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UpdatePersonalInfoDTO [username=" + username + ", names=" + names + ", surnames=" + surnames
				+ ", personal_mail=" + personal_mail + ", token=" + token + "]";
	}

}
