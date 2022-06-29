package com.wposs.alfa.modules.user.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class UpdatePersonalInfoInput implements Serializable {

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
	String phone;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String adress;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String country;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String state;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String city;
	

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

	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "UpdatePersonalInfoInput [username=" + username + ", names=" + names + ", surnames=" + surnames
				+ ", personal_mail=" + personal_mail + ", phone=" + phone + ", adress=" + adress + ", country="
				+ country + ", state=" + state + ", city=" + city + ", token=" + token + "]";
	}

}
