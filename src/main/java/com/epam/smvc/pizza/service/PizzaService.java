package com.epam.smvc.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.smvc.pizza.domain.Pizza;
import com.epam.smvc.pizza.repository.PizzaRepository;

@Service
public class PizzaService {
	@Autowired
	private PizzaRepository repository;

	public void addPizza(final Pizza pizza) {
		this.repository.addPizzas(pizza);
	}

	public List<Pizza> getRepository() {
		return repository.getPizzas();
	}
}
