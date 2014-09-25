package com.epam.smvc.pizza.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.smvc.pizza.service.NewsService;

@Controller
@SessionAttributes({ "cart", "orderData", "user" })
public class HomeController {
	// private static final Logger logger = LoggerFactory
	// .getLogger(MainController.class);

	@Autowired
	private NewsService newsService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(final Locale locale, final Model model) {
		if (!model.containsAttribute("user")) {
			model.addAttribute("user", "anonymous");
		}
		model.addAttribute("news", newsService.getRepository());
		return "home";
	}
}
