package com.wposs.alfa.modules.user.model;

import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import org.springframework.lang.NonNull;

public class CreateUserPersonInput implements Serializable{

	private static final long serialVersionUID = 876523106472897660L;
	
	//DATOS PARA PERSONAS
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String names;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String last_names;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String document_type;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String document;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String corporate_mail;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String personal_mail;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String birthday_date;
	
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
	
	//DATOS PARA USUARIOS
	
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String username;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String ip;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String password;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String ip_device;
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String type_device;

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLast_names() {
		return last_names;
	}

	public void setLast_names(String last_names) {
		this.last_names = last_names;
	}

	public String getDocument_type() {
		return document_type;
	}

	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getCorporate_mail() {
		return corporate_mail;
	}

	public void setCorporate_mail(String corporate_mail) {
		this.corporate_mail = corporate_mail;
	}

	public String getPersonal_mail() {
		return personal_mail;
	}

	public void setPersonal_mail(String personal_mail) {
		this.personal_mail = personal_mail;
	}

	public String getBirthday_date() {
		return birthday_date;
	}

	public void setBirthday_date(String birthday_date) {
		this.birthday_date = birthday_date;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getIp_device() {
		return ip_device;
	}

	public void setIp_device(String ip_device) {
		this.ip_device = ip_device;
	}

	public String getType_device() {
		return type_device;
	}

	public void setType_device(String type_device) {
		this.type_device = type_device;
	}

	@Override
	public String toString() {
		return "CreateUserPersonInput [names=" + names + ", last_names=" + last_names + ", document_type="
				+ document_type + ", document=" + document + ", corporate_mail=" + corporate_mail + ", personal_mail="
				+ personal_mail + ", birthday_date=" + birthday_date + ", phone=" + phone + ", adress=" + adress
				+ ", country=" + country + ", state=" + state + ", city=" + city + ", username=" + username + ", ip="
				+ ip + ", password=" + password + ", ip_device=" + ip_device + ", type_device=" + type_device + "]";
	}
	
}
