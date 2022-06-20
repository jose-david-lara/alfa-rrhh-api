package com.wposs.alfa.modules.persons.model;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PersonByDocumentInput implements Serializable{

	private static final long serialVersionUID = -6866287639429103034L;
	
	@NotNull
	@NotBlank(message =  "El campo no puede estar vacio")
	String document_type;
	
	@NotNull
	@NotBlank(message =  "El campo no puede estar vacio")
	String document;
	
	
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
	
	
	@Override
	public String toString() {
		return "PersonByDocumentInputDTO [document_type=" + document_type + ", document=" + document + "]";
	} 
	
}
