package com.epam.smvc.pizza.domain;

public class Pizza {
	private String name;
	private double price;
	private String topping;
	private String file;

	public Pizza() {
	}

	public Pizza(String name, double price, String topping, String file) {
		this.name = name;
		this.price = price;
		this.topping = topping;
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(final double price) {
		this.price = price;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(final String topping) {
		this.topping = topping;
	}

	public String getFile() {
		return file;
	}

	public void setFile(final String file) {
		this.file = file;
	}
}
