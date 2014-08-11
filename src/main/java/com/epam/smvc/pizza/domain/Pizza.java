package com.epam.smvc.pizza.domain;

public class Pizza {
	private String name;
	private int price;
	private String topping;
	private String file;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(final int price) {
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
