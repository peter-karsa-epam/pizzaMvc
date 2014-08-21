package com.epam.smvc.pizza.domain;

import java.util.Date;
import java.util.List;

public class Order {
	private OrderData data;
	private List<Pizza> pizzas;
	private Date date;

	public Order() {
	}

	public Order(final OrderData data, final List<Pizza> pizzas, final Date date) {
		this.data = data;
		this.pizzas = pizzas;
		this.date = date;
	}

	public OrderData getData() {
		return data;
	}

	public void setData(OrderData data) {
		this.data = data;
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

	public void setDate(Date date) {
		this.date = date;
	}
}
