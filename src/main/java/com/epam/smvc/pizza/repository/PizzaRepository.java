package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.Pizza;

@Repository
public class PizzaRepository {
	private List<Pizza> pizzas = new ArrayList<>();

	public List<Pizza> getPizzas() {
		return Collections.unmodifiableList(pizzas);
	}

	public void addPizzas(final Pizza pizza) {
		this.pizzas.add(pizza);
	}
}
