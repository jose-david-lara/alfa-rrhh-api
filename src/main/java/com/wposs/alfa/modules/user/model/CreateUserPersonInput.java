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
	
	@NonNull
	@NotBlank(message = "El campo no puede esta vacio")
	String token;
	
	
}
