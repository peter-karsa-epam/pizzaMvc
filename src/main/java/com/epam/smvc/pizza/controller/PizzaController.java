package com.epam.smvc.pizza.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.smvc.pizza.service.PizzaService;

@Controller
@SessionAttributes({ "cart", "orderData", "user" })
public class PizzaController {
	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);
	@Autowired
	private PizzaService pizzaService;
}
