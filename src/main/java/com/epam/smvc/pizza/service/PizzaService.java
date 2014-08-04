package com.epam.smvc.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.smvc.pizza.domain.Pizza;
import com.epam.smvc.pizza.repository.PizzaRepository;

/**
 * 
 * @author Peter_Karsa
 *
 */
@Service
public class PizzaService {
	@Autowired
	private PizzaRepository repository;

	public void addPizza(final Pizza pizza) {
		this.repository.addPizzas(pizza);
	}

	public PizzaRepository getRepository() {
		return repository;
	}
}
