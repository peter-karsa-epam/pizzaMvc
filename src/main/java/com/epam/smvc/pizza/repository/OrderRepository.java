package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.Order;

@Repository
public class OrderRepository {
	private List<Order> orders = new ArrayList<>();

	public List<Order> getOrders() {
		return orders;
	}

	public void addOrder(final Order order) {
		this.orders.add(order);
	}
}
