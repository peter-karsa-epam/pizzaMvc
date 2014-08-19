package com.epam.smvc.pizza.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.epam.smvc.pizza.domain.Message;
import com.epam.smvc.pizza.domain.News;
import com.epam.smvc.pizza.domain.Pizza;
import com.epam.smvc.pizza.domain.User;
import com.epam.smvc.pizza.service.MessageService;
import com.epam.smvc.pizza.service.NewsService;
import com.epam.smvc.pizza.service.PizzaService;
import com.epam.smvc.pizza.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);
	@Autowired
	private MessageService msgService;
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(final Locale locale, final Model model) {
		populateData(model);
		return "home";
	}

	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String pizza(final Locale locale, final Model model) {
		populateData(model);
		return "pizza";
	}

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(final Locale locale, final Model model) {
		populateData(model);
		return "message";
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(final Locale locale, final Model model) {
		populateData(model);
		return "contact";
	}

	// @RequestMapping(value = "/login", method = RequestMethod.GET)
	// public String admin(final Locale locale, final Model model) {
	// populateData(model);
	// return "login";
	// }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			final Locale locale, final Model model) {

		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}

		return "administrator";
	}

	@RequestMapping(value = "/addMsg", method = RequestMethod.POST)
	public String messagePost(
			@RequestParam(value = "name", required = false) final String name,
			@RequestParam(value = "text", required = false) final String text,
			final Locale locale, final Model model) {
		if (!name.isEmpty() && !text.isEmpty()) {
			Message msg = new Message();
			msg.setName(name);
			msg.setDate(new Date());
			msg.setMessage(text);
			msgService.addRepository(msg);
		}
		logger.info(name);
		logger.info(text);

		populateData(model);
		return "redirect:/message";
	}

	@RequestMapping(value = "/loginToPizza", method = RequestMethod.POST)
	public String loginA(
			@RequestParam(value = "user", required = false) final String user,
			@RequestParam(value = "password", required = false) final String password,
			final Locale locale, final Model model) {
		String ret = "redirect:/admin";
		for (User curr : userService.getRepository()) {
			if (curr.isAdmin()) {
				if (user.equals(curr.getUser())
						&& password.equals(curr.getPassword())) {
					ret = "administrator";
					break;
				}
			}
		}

		populateData(model);
		return ret;
	}

	@RequestMapping(value = "/addNews", method = RequestMethod.POST)
	public String addNews(
			@RequestParam(value = "newsTitle", required = false) final String title,
			@RequestParam(value = "newsContent", required = false) final String text,
			final Locale locale, final Model model) {

		if (!title.isEmpty() && !text.isEmpty()) {
			News news = new News();
			news.setTitle(title);
			news.setContent(text);
			news.setDateAdded(new Date());
			newsService.addRepository(news);
			logger.info(title);
			logger.info(text);
			model.addAttribute("newss", newsService.getRepository());
		}
		populateData(model);
		return "administrator";
	}

	@RequestMapping(value = "/addPizza", method = RequestMethod.POST)
	public String addPizza(@RequestParam("name") final String name,
			@RequestParam("toppings") final String toppings,
			@RequestParam("price") final double price,
			@RequestParam("image") MultipartFile picture, final Locale locale,
			final Model model) {

		if (!picture.isEmpty() && !toppings.isEmpty() && price != 0
				&& !name.isEmpty()) {
			saveImage(name + ".jpg", picture);

			Pizza pizza = new Pizza();
			pizza.setId(getNewId());
			pizza.setName(name);
			pizza.setTopping(toppings);
			pizza.setPrice(price);
			pizza.setFile("resources/pizzapic/" + name + ".jpg");
			pizzaService.addPizza(pizza);

			populateData(model);
		} else {

		}
		return "administrator";
	}

	private int getNewId() {
		return 1 + pizzaService.getMaxId();
	}

	private void saveImage(final String name, final MultipartFile image) {
		try {
			File file = new File(
					"d:\\pizzaMvc\\src\\main\\webapp\\resources\\pizzapic\\"
							+ name);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
			System.out.println("OKOK");
		} catch (IOException ioex) {
		}
	}

	private void populateData(Model model) {
		model.addAttribute("messages", msgService.getRepository());
		model.addAttribute("pizzas", pizzaService.getRepository());
		model.addAttribute("news", newsService.getRepository());
	}
}
