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

	public int getMaxId() {
		int max = 0;
		for (Pizza pizza : repository.getPizzas()) {
			if (pizza.getId() > max) {
				max = pizza.getId();
			}
		}
		return max;
	}
}
