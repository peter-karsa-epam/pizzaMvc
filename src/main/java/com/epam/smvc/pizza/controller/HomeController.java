package com.epam.smvc.pizza.controller;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.smvc.pizza.domain.Message;
import com.epam.smvc.pizza.service.MessageService;
import com.epam.smvc.pizza.service.NewsService;
import com.epam.smvc.pizza.service.PizzaService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);
	@Autowired
	private MessageService msgService;
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private NewsService newsService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		// logger.info("Welcome home! The client locale is {}.", locale);
		// Date date = new Date();
		// DateFormat dateFormat =
		// DateFormat.getDateTimeInstance(DateFormat.LONG,
		// DateFormat.LONG, locale);
		// String formattedDate = dateFormat.format(date);
		// model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String pizza(Locale locale, Model model) {
		return "pizza";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(Locale locale, Model model) {
		populateData(model);
		return "message";
	}

	@RequestMapping(value = "/addMsg", method = RequestMethod.POST)
	public String messagePost(
			@RequestParam(value = "name", required = false) final String name,
			@RequestParam(value = "text", required = false) final String text,
			final Locale locale, final Model model) {
		Message msg = new Message();
		msg.setName(name);
		msg.setDate(new Date());
		msg.setMessage(text);
		msgService.addRepository(msg);

		logger.info(name);
		logger.info(text);

		populateData(model);
		return "message";
	}

	private void populateData(Model model) {
		model.addAttribute("messages", msgService.getRepository());
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(Locale locale, Model model) {
		return "contact";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(Locale locale, Model model) {
		return "admin";
	}

	@RequestMapping(value = "/administrator", method = RequestMethod.GET)
	public String administrator(Locale locale, Model model) {
		return "administrator";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String login() {
		return "administrator";
	}
}
