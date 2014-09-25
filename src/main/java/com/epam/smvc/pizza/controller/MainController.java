package com.epam.smvc.pizza.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.smvc.pizza.service.UserService;

@Controller
@SessionAttributes({ "cart", "orderData", "user" })
public class MainController {
	// private static final Logger logger = LoggerFactory
	// .getLogger(MainController.class);

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(final Locale locale, final Model model) {
		return "redirect:/home";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(final Locale locale, final Model model,
			HttpServletRequest req, HttpServletResponse resp,
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		String ret = "login";
		if (error != null) {
			model.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
			ret = "home";
		}

		if (req.isUserInRole("ROLE_ADMIN")) {
			ret = "admin";
		}
		return ret;
	}
}
