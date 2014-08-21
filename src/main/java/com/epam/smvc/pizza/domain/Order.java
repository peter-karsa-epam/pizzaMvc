package com.epam.smvc.pizza.domain;

import java.util.Date;
import java.util.List;

public class Order {
	private String name;
	private String address;
	private String city;
	private String zipcode;
	private long phone;
	private String comment;
	private List<Pizza> pizzas;
	private Date date;

	public Order() {
	}

	public Order(String name, String address, String city, String zipcode,
			long phone, String comment, List<Pizza> pizzas, Date date) {
		this.name = name;
		this.address = address;
		this.city = city;
		this.zipcode = zipcode;
		this.phone = phone;
		this.comment = comment;
		this.pizzas = pizzas;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(final String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(final String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(final String zipcode) {
		this.zipcode = zipcode;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(final long phone) {
		this.phone = phone;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setPizzas(final List<Pizza> pizzas) {
		this.pizzas.clear();
		this.pizzas.addAll(pizzas);
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}
}
