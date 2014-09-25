package com.epam.smvc.pizza.controller;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.smvc.pizza.domain.Message;
import com.epam.smvc.pizza.service.MessageService;

@Controller
@SessionAttributes({ "cart", "orderData", "user" })
public class MessageController {
	// private static final Logger logger = LoggerFactory
	// .getLogger(MainController.class);

	@Autowired
	private MessageService msgService;

	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message(final Locale locale, final Model model) {
		model.addAttribute("messages", msgService.getRepository());
		return "message";
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
		return "redirect:/message";
	}
}
