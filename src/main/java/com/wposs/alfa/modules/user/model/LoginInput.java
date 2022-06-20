package com.wposs.alfa.modules.user.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

@Entity
public class LoginInput implements Serializable{
	
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
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String device_last;
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	private String type_device;
	
	
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
	public String getDevice_last() {
		return device_last;
	}
	public void setDevice_last(String device_last) {
		this.device_last = device_last;
	}
	public String getType_device() {
		return type_device;
	}
	public void setType_device(String type_device) {
		this.type_device = type_device;
	}
	
	
	@Override
	public String toString() {
		return "LoginInputDTO [username=" + username + ", password=" + password + ", ip=" + ip + ", device_last="
				+ device_last + ", type_device=" + type_device + "]";
	}

}
