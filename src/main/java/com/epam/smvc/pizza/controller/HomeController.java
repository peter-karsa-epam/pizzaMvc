package com.epam.smvc.pizza.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.epam.smvc.pizza.domain.Message;
import com.epam.smvc.pizza.domain.News;
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

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(final Locale locale, final Model model) {
		populateData(model);
		return "contact";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin(final Locale locale, final Model model) {
		populateData(model);
		return "admin";
	}

	@RequestMapping(value = "/administrator", method = RequestMethod.GET)
	public String administrator(final Locale locale, final Model model) {
		populateData(model);
		return "administrator";
	}

	@RequestMapping(value = "/administratorLogin", method = RequestMethod.POST)
	public String login(final Locale locale, final Model model) {
		populateData(model);
		return "administrator";
	}

	@RequestMapping(value = "/addNews", method = RequestMethod.POST)
	public String addNews(
			@RequestParam(value = "newsTitle", required = false) final String title,
			@RequestParam(value = "newsContent", required = false) final String text,
			final Locale locale, final Model model) {
		News news = new News();
		news.setTitle(title);
		news.setContent(text);
		news.setDateAdded(new Date());
		newsService.addRepository(news);

		logger.info(title);
		logger.info(text);

		model.addAttribute("newss", newsService.getRepository());
		populateData(model);
		return "administrator";
	}

	@RequestMapping(value = "/addPizza", method = RequestMethod.POST)
	public @ResponseBody String addPizza(
			@RequestParam("name") String name,
			@RequestParam("toppings") String toppings,
			@RequestParam("price") int price,
			@RequestParam("picture") MultipartFile file) {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				logger.info("Server File Location="
						+ serverFile.getAbsolutePath());

				return "You successfully uploaded file=" + name;
			} catch (Exception e) {
				return "You failed to upload " + name + " => " + e.getMessage();
			}
		} else {
			return "You failed to upload " + name
					+ " because the file was empty.";
		}
	}

	private void populateData(Model model) {
		model.addAttribute("messages", msgService.getRepository());
		model.addAttribute("pizzas", pizzaService.getRepository());
		model.addAttribute("news", newsService.getRepository());
	}
}
