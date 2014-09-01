package com.epam.smvc.pizza.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Order {
	private int orderId;
	private OrderData data;
	private List<Pizza> pizzas = new ArrayList<Pizza>();
	private double totalCost;
	private Date date;
	private boolean isDelivered = false;

	public Order() {
		setDelivered(false);

		for (Pizza item : pizzas) {
			totalCost += item.getPrice();
		}
	}

	public Order(final OrderData data, final List<Pizza> pizzas, final Date date) {
		this.data = data;
		setPizzas(pizzas);
		this.date = date;

		for (Pizza item : pizzas) {
			totalCost += item.getPrice();
		}
	}

	public OrderData getData() {
		return data;
	}

	public void setData(OrderData data) {
		this.data = data;
	}

	public List<Pizza> getPizzas() {
		return Collections.unmodifiableList(pizzas);
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

	public boolean isDelivered() {
		return isDelivered;
	}

	public void setDelivered(final boolean isDelivered) {
		this.isDelivered = isDelivered;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
}
