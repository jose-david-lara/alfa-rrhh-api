package com.wposs.alfa.modules.user.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

public class UpdateStateUser implements Serializable {

	private static final long serialVersionUID = 2581704854855101989L;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String username;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String state;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String token;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UpdateStateUser [username=" + username + ", state=" + state + ", token=" + token + "]";
	}
	
}
