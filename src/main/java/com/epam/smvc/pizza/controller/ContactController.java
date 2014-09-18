package com.epam.smvc.pizza.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "cart", "orderData", "user" })
public class ContactController {
	private static final Logger logger = LoggerFactory
			.getLogger(MainController.class);
}
