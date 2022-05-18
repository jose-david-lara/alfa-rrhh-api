package com.wposs.alfa.modules.test.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

import org.springframework.lang.NonNull;

@Entity
public class TestInput implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2151737440365190241L;
	
	@NonNull
	@NotBlank(message = "El campo -test- no puede estar vacio")
	private String test;

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	

	@Override
	public String toString() {
		return "TestInput [test=" + test + "]";
	}

}
