package com.epam.smvc.pizza.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.smvc.pizza.domain.Order;
import com.epam.smvc.pizza.service.OrderService;
import com.epam.smvc.pizza.service.PizzaService;

@Controller
public class AdminController {
	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);
	@Autowired
	private OrderService orderService;
	@Autowired
	private PizzaService pizzaService;

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(final Locale locale, final Model model) {
		filterDeliveredOrders(model);
		return "admin";
	}

	@RequestMapping(value = "/adminNews", method = RequestMethod.GET)
	public String adminNewsAndNewProducts(final Locale locale, final Model model) {
		model.addAttribute("pizzas", pizzaService.getRepository());
		return "adminNews";
	}

	@RequestMapping(value = "/setDelivered", method = RequestMethod.POST)
	public String setItemDelivered(final Locale locale, final Model model,
			final String name, final String date) {
		for (Order item : orderService.getRepository()) {
			if (date.equals(item.getDate().toString()) && name.equals(name)) {
				item.setDelivered(true);
			}
		}
		filterDeliveredOrders(model);
		return "redirect:/admin";
	}

	private void filterDeliveredOrders(final Model model) {
		List<Order> orders = new ArrayList<>();
		orders.clear();
		orders.addAll(orderService.getRepository());

		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).isDelivered()) {
				orders.remove(i);
				i--;
			}
		}

		model.addAttribute("orders", orders);
	}
}
