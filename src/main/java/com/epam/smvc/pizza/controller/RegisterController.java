package com.epam.smvc.pizza.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.smvc.pizza.entities.User;
import com.epam.smvc.pizza.service.MailSender;

@Controller
public class RegisterController {
	// private static final Logger logger = LoggerFactory
	// .getLogger(RegisterController.class);

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(final Locale locale, final Model model) {
		return "register";
	}

	@RequestMapping(value = "registerNewUser", method = RequestMethod.POST)
	public String registerNewUser(final Locale locale, final Model model,
			final String name, final String city, final String address,
			final String zipcode, final String phone, final String email,
			final String user, final String password) {
		String ret = "redirect:/home";
		if (name.isEmpty() || city.isEmpty() || address.isEmpty()
				|| zipcode.isEmpty() || phone.isEmpty() || email.isEmpty()
				|| user == null || user.isEmpty() || password == null
				|| password.isEmpty()) {

			ret = "redirect:/register";
		} else {
			User newUser = new User();
			newUser.setName(name);
			newUser.setCity(city);
			newUser.setAddress(address);
			newUser.setZipcode(zipcode);
			newUser.setPhone(phone);
			newUser.setEmail(email);
			newUser.setUser(user);
			newUser.setPassword(password);
			newUser.setAdmin(false);

			//
			// persist user to db
			//

			MailSender senderService = MailSender.getInstance();
			senderService.send(email, name);
		}
		return ret;
	}
}
