package com.example.employeeAPI.model;

import javax.persistence.*;

@Entity
@Table(name = "emp_address")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private String street;
	private String city;
	private String state;

	public Address() {
		super();

	}

	public Address( String street, String city, String state) {
		super();
		
		this.street = street;
		this.city = city;
		this.state = state;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

		public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId  + ", street=" + street + ", city="
				+ city + ", state=" + state + "]";
	}
	
	

	
}
