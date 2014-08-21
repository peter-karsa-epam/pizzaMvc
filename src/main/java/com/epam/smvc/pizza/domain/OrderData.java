package com.epam.smvc.pizza.domain;

public class OrderData {
	public String name;
	public String address;
	public String city;
	public String zipcode;
	public long phone;
	public String comment;

	public OrderData() {
	}

	public OrderData(String name, String address, String city, String zipcode,
			long phone, String comment) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
		this.comment = comment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}