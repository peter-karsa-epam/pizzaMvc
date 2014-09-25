package com.epam.smvc.pizza.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.epam.smvc.pizza.domain.News;
import com.epam.smvc.pizza.domain.Order;
import com.epam.smvc.pizza.domain.Pizza;
import com.epam.smvc.pizza.service.NewsService;
import com.epam.smvc.pizza.service.OrderService;
import com.epam.smvc.pizza.service.PizzaService;

@Controller
public class AdminController {
	// private static final Logger logger = LoggerFactory
	// .getLogger(MainController.class);

	@Autowired
	private OrderService orderService;
	@Autowired
	private PizzaService pizzaService;
	@Autowired
	private NewsService newsService;

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
		}
		return "redirect:/adminNews";
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

			model.addAttribute("newss", newsService.getRepository());
		}
		return "redirect:/adminNews";
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

	private int getNewId() {
		return 1 + pizzaService.getMaxId();
	}

	private void saveImage(final String name, final MultipartFile image) {
		try {
			//
			//
			// IMPORTANT: configure file path to local environment!
			//
			//
			File file = new File(
					"d:\\pizzaMvc\\src\\main\\webapp\\resources\\pizzapic\\"
							+ name);
			FileUtils.writeByteArrayToFile(file, image.getBytes());
		} catch (IOException ioex) {
			//
		}
	}
}
