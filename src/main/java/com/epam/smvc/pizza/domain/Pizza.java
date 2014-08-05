package com.epam.smvc.pizza.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza {
	private String name;
	private int price;
	private List<String> topping = new ArrayList<>();
	private boolean isVegan;
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

	public List<String> getTopping() {
		return Collections.unmodifiableList(topping);
	}

	public void setTopping(final List<String> topping) {
		this.topping.clear();
		this.topping.addAll(topping);
	}

	public boolean isVegan() {
		return isVegan;
	}

	public void setVegan(final boolean isVegan) {
		this.isVegan = isVegan;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
}
