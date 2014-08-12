package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.Pizza;

@Repository
public class PizzaRepository {
	private List<Pizza> pizzas = new ArrayList<>();

	public PizzaRepository() {
		pizzas.add(new Pizza("Margherita", 1.99, "Tomato sauce, cheese",
				"resources/pizzapic/Margherita.jpg"));
		pizzas.add(new Pizza("Vegan", 5.99, "Vegetables, cheese",
				"resources/pizzapic/Vegan.jpg"));
		pizzas.add(new Pizza("Hawaii", 2.99, "Tomato sauce, ham, pineapple, cheese",
				"resources/pizzapic/Hawaii.jpg"));
		pizzas.add(new Pizza("Meaty", 5.99, "Tomato sauce, ham, salami, bacon, cheese",
				"resources/pizzapic/Meaty.jpg"));
		pizzas.add(new Pizza("San francisco", 2.99, "Tomato sauce, salami, cheese",
				"resources/pizzapic/Sanfrancisco.jpg"));
	}

	public List<Pizza> getPizzas() {
		return Collections.unmodifiableList(pizzas);
	}

	public void addPizzas(final Pizza pizza) {
		this.pizzas.add(pizza);
	}
}
