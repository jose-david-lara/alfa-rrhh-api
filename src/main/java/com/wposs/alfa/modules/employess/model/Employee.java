package com.wposs.alfa.modules.employess.model;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private String idEmployee;
	private String name;
	private String lastName;
	private String age;
	private String birthday;
	private String adress;
	private String country;
	private String state;
	private String city;
	private String numberId;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4851980110789317933L;

	public String getIdEmployee() {
		return idEmployee;
	}

	public void setIdEmployee(String idEmployee) {
		this.idEmployee = idEmployee;
	}

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
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

	public String getNumberId() {
		return numberId;
	}

	public void setNumberId(String numberId) {
		this.numberId = numberId;
	}

	@Override
	public String toString() {
		return "Employee [idEmployee=" + idEmployee + ", name=" + name + ", lastName=" + lastName + ", age=" + age
				+ ", birthday=" + birthday + ", adress=" + adress + ", country=" + country + ", state=" + state
				+ ", city=" + city + ", numberId=" + numberId + "]";
	}
	
}
