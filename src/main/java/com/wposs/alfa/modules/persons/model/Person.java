package com.wposs.alfa.modules.persons.model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable{
	
	String name;
	String lastName;
	String documentType;
	String document;
	String corporateMail;
	String personalMail;
	Date birthdayDate;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3717099885938913967L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getCorporateMail() {
		return corporateMail;
	}

	public void setCorporateMail(String corporateMail) {
		this.corporateMail = corporateMail;
	}

	public String getPersonalMail() {
		return personalMail;
	}

	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", lastName=" + lastName + ", documentType=" + documentType + ", document="
				+ document + ", corporateMail=" + corporateMail + ", personalMail=" + personalMail + ", birthdayDate="
				+ birthdayDate + "]";
	}
	
}
