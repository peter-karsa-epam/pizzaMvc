package com.epam.smvc.pizza.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.smvc.pizza.domain.Pizza;
import com.epam.smvc.pizza.service.PizzaService;
import com.epam.smvc.pizza.service.UserService;

@Controller
@SessionAttributes({ "cart", "orderData", "user" })
public class PizzaController {
	// private static final Logger logger = LoggerFactory
	// .getLogger(MainController.class);

	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String pizza(final Locale locale, final Model model) {
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new ArrayList<Pizza>());
		}
		model.addAttribute("pizzas", pizzaService.getRepository());
		return "pizza";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(final int quantity, final String name,
			final double price, @ModelAttribute("cart") List<Pizza> cart,
			final Model model) {

		Pizza pizza = getPizza(name);
		for (int i = 0; i < quantity; i++) {
			cart.add(pizza);
		}
		return "redirect:/pizza";
	}

	private Pizza getPizza(final String pizzaName) {
		Pizza p = null;
		for (Pizza pizza : pizzaService.getRepository()) {
			if (pizzaName.equals(pizza.getName())) {
				p = pizza;
			}
		}
		return p;
	}
}
