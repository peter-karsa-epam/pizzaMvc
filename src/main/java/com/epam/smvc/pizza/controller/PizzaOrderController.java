package com.epam.smvc.pizza.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.smvc.pizza.service.PizzaService;

/**
 * @author Peter_Karsa
 *
 */
@Controller
@SessionAttributes("")
public class PizzaOrderController {
	private static final Logger LOG = LoggerFactory
			.getLogger(PizzaOrderController.class);

	@Autowired
	private PizzaService service;

	@RequestMapping(value = "/pizzas", method = RequestMethod.GET)
	public String getPizzas(final Model model) {
		return "pizzas";
	}
}
