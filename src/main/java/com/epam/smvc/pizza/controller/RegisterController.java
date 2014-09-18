package com.epam.smvc.pizza.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.smvc.pizza.service.MailSender;

@Controller
public class RegisterController {

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String register(final Locale locale, final Model model) {
		return "register";
	}

	@RequestMapping(value = "registerNewUser", method = RequestMethod.POST)
	public String registerNewUser(final Locale locale, final Model model,
			final String name, final String city, final String address,
			final String zipcode, final String phone, final String email,
			final String user, final String password) {

		MailSender senderService = MailSender.getInstance();
		senderService.send(email, name);

		return "redirect:/home";
	}
}
