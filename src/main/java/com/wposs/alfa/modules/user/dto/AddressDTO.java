package com.wposs.alfa.modules.user.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

public class AddressDTO implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7961543017395565518L;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String address;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String name;
	@NonNull
	@NotBlank(message = "El campo no puede estar vacio")
	private String type_address;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType_address() {
		return type_address;
	}
	public void setType_address(String type_address) {
		this.type_address = type_address;
	}
	@Override
	public String toString() {
		return "AddressDTO [address=" + address + ", name=" + name + ", type_address=" + type_address + "]";
	}


}
