package com.wposs.alfa.modules.user.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

@Entity
public class LoginInputDTO implements Serializable{
	
	private static final long serialVersionUID = -581482128021864287L;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String username; 
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String password; 
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String ip;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	} 

	
	@Override
	public String toString() {
		return "LoginInput [userName=" + username + ", password=" + password + ", ip=" + ip + "]";
	}

}
