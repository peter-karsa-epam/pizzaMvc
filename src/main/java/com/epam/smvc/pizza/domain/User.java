package com.epam.smvc.pizza.domain;

public class User {
	private OrderData data = new OrderData();
	private String user;
	private String password;
	private boolean isAdmin;
	private String email;

	public User() {

	}

	public User(final String name, final String user, final String password,
			final boolean isAdmin, final String address, final String city,
			final String zipcode, final int phone, final String email) {
		this.data.setName(name);
		this.user = user;
		this.password = password;
		this.isAdmin = isAdmin;
		this.data.setAddress(address);
		this.data.setCity(city);
		this.data.setZipcode(zipcode);
		this.data.setPhone(phone);
		this.email = email;
	}

	public String getName() {
		return data.getName();
	}

	public void setName(final String name) {
		this.data.setName(name);
	}

	public String getAddress() {
		return data.getAddress();
	}

	public void setAddress(final String address) {
		this.data.setAddress(address);
	}

	public String getCity() {
		return data.getCity();
	}

	public void setCity(final String city) {
		this.data.setCity(city);
	}

	public String getZipcode() {
		return data.getZipcode();
	}

	public void setZipcode(final String zipcode) {
		this.data.setZipcode(zipcode);
	}

	public long getPhone() {
		return data.getPhone();
	}

	public void setPhone(final long phone) {
		this.data.setPhone(phone);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getUser() {
		return user;
	}

	public void setUser(final String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(final boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public OrderData getData() {
		return data;
	}

	public void setData(OrderData data) {
		this.data = data;
	}
}
