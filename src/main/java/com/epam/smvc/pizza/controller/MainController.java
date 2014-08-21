package com.epam.smvc.pizza.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.epam.smvc.pizza.domain.Message;
import com.epam.smvc.pizza.domain.News;
import com.epam.smvc.pizza.domain.Order;
import com.epam.smvc.pizza.domain.OrderData;
import com.epam.smvc.pizza.domain.Pizza;
import com.epam.smvc.pizza.domain.User;
import com.epam.smvc.pizza.service.MessageService;
import com.epam.smvc.pizza.service.NewsService;
import com.epam.smvc.pizza.service.OrderService;
import com.epam.smvc.pizza.service.PizzaService;
import com.epam.smvc.pizza.service.UserService;

@Controller
@SessionAttributes({ "cart", "orderData" })
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
	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(final Locale locale, final Model model) {
		populateData(model);
		return "home";
	}

	@RequestMapping(value = "/pizza", method = RequestMethod.GET)
	public String pizza(final Locale locale, final Model model) {
		if (!model.containsAttribute("cart")) {
			model.addAttribute("cart", new ArrayList<Pizza>());
		}
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

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(final Locale locale, final Model model,
			@ModelAttribute("cart") List<Pizza> cart) {
		double sum = 0;
		for (Pizza item : cart) {
			sum += item.getPrice();
		}

		model.addAttribute("totalPrice", sum);
		populateData(model);
		return "order";
	}

	@RequestMapping(value = "/finalizeOrder", method = RequestMethod.POST)
	public String finalizeOrder(final String name, final String address,
			final String city, final String zipcode, final long phone,
			final String comment, @ModelAttribute("cart") List<Pizza> cart,
			final Locale locale, final Model model) {

		logger.info(name);
		logger.info(address);
		logger.info(city);
		logger.info(zipcode);
		logger.info(Long.toString(phone));
		logger.info(comment);

		double sum = 0;
		for (Pizza item : cart) {
			sum += item.getPrice();
		}

		model.addAttribute("orderData", new OrderData(name, address, city,
				zipcode, phone, comment));

		model.addAttribute("totalPrice", sum);
		populateData(model);
		return "finalize";
	}

	@RequestMapping(value = "/thanks", method = RequestMethod.GET)
	public String orderNow(final Locale locale, final Model model,
			@ModelAttribute("cart") List<Pizza> cart,
			@ModelAttribute("orderData") OrderData orderData) {
		orderPut(cart, orderData);

		populateData(model);
		return "thanks";
	}

	private void orderPut(List<Pizza> cart, OrderData orderData) {
		Order order = new Order(orderData, cart, new Date());
		orderService.addOrder(order);
		cart.clear();
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(final int quantity, final String name,
			final double price, @ModelAttribute("cart") List<Pizza> cart,
			final Model model) {
		logger.info("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"
				+ Integer.toString(quantity));
		logger.info(name);
		logger.info(Double.toString(price));
		logger.info(Integer.toString(cart.size()));

		Pizza pizza = getPizza(name);
		for (int i = 0; i < quantity; i++) {
			cart.add(pizza);
		}

		populateData(model);
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
