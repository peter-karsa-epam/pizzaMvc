package com.epam.smvc.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.smvc.pizza.domain.Order;
import com.epam.smvc.pizza.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository repository;

	public List<Order> getRepository() {
		return repository.getOrders();
	}

	public void addOrder(final Order order) {
		this.repository.addOrder(order);
	}
}
