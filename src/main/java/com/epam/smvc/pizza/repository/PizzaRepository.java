package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.Pizza;

@Repository
public class PizzaRepository {
	private List<Pizza> pizzas = new ArrayList<>();

	//just for test
	public PizzaRepository() {
		pizzas.add(new Pizza(1, "Margherita", 1.99, "Tomato sauce, cheese",
				"resources/pizzapic/Margherita.jpg"));
		pizzas.add(new Pizza(2, "Vegan", 5.99, "Vegetables, cheese",
				"resources/pizzapic/Vegan.jpg"));
		pizzas.add(new Pizza(3, "Hawaii", 2.99,
				"Tomato sauce, ham, pineapple, cheese",
				"resources/pizzapic/Hawaii.jpg"));
		pizzas.add(new Pizza(4, "Meaty", 5.99,
				"Tomato sauce, ham, salami, bacon, cheese",
				"resources/pizzapic/Meaty.jpg"));
		pizzas.add(new Pizza(5, "San francisco", 2.99,
				"Tomato sauce, salami, cheese",
				"resources/pizzapic/Sanfrancisco.jpg"));
	}

	public List<Pizza> getPizzas() {
		return Collections.unmodifiableList(pizzas);
	}

	public void addPizzas(final Pizza pizza) {
		this.pizzas.add(pizza);
	}
}
