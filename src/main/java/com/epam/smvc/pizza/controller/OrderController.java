package com.epam.smvc.pizza.controller;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.smvc.pizza.domain.Order;
import com.epam.smvc.pizza.domain.OrderData;
import com.epam.smvc.pizza.domain.Pizza;
import com.epam.smvc.pizza.domain.User;
import com.epam.smvc.pizza.service.MailSender;
import com.epam.smvc.pizza.service.OrderService;
import com.epam.smvc.pizza.service.UserService;

@Controller
@SessionAttributes({ "cart", "orderData", "user" })
public class OrderController {
	// private static final Logger logger = LoggerFactory
	// .getLogger(MainController.class);

	@Autowired
	private OrderService orderService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/order", method = RequestMethod.GET)
	public String order(final Locale locale, final Model model,
			HttpServletRequest req, @ModelAttribute("cart") List<Pizza> cart,
			@ModelAttribute("user") final String username) {
		String ret = "order";
		if (!cart.isEmpty()) {
			if (req.isUserInRole("ROLE_USER")) {
				if (!model.containsAttribute("user")) {
					model.addAttribute("user", username);
				}
				getUserData(username, model);
			}
			getCartPrice(model, cart);
		} else {
			ret = "redirect:/pizza";
		}
		return ret;
	}

	@RequestMapping(value = "/thanks", method = RequestMethod.GET)
	public String orderNow(final Locale locale, final Model model,
			@ModelAttribute("cart") List<Pizza> cart,
			@ModelAttribute("orderData") OrderData orderData) {
		orderPut(cart, orderData);

		MailSender mailSenderService = MailSender.getInstance();

		mailSenderService.send("testforluigipizza@gmail.com",
				orderData.getName(), "#1");

		model.addAttribute("orderId", "#1");
		return "thanks";
	}

	@RequestMapping(value = "/finalizeOrder", method = RequestMethod.POST)
	public String finalizeOrder(final String name, final String address,
			final String city, final String zipcode, final long phone,
			final String comment, @ModelAttribute("cart") List<Pizza> cart,
			final Locale locale, final Model model) {

		double sum = 0;
		for (Pizza item : cart) {
			sum += item.getPrice();
		}

		model.addAttribute("orderData", new OrderData(name, address, city,
				zipcode, phone, comment));

		model.addAttribute("totalPrice", new DecimalFormat("##.##").format(sum));
		return "finalize";
	}

	@RequestMapping(value = "/removeAllItems", method = RequestMethod.GET)
	public String removeAllItems(final Locale locale, final Model model,
			@ModelAttribute("cart") List<Pizza> cart) {
		cart.clear();
		return "redirect:/pizza";
	}

	@RequestMapping(value = "/postUserNameLoggedIn", method = RequestMethod.POST)
	public String orderWithLoggedInUser(HttpServletRequest req,
			final String username, final Locale locale, final Model model,
			@ModelAttribute("cart") List<Pizza> cart) {
		String ret = "redirect:/order";
		if (!cart.isEmpty()) {
			if (req.isUserInRole("ROLE_USER")) {
				model.addAttribute("user", username);
			}
			getUserData(username, model);
			getCartPrice(model, cart);
		} else {
			ret = "redirect:/pizza";
		}
		return ret;
	}

	@RequestMapping(value = "/removeItemFromList", method = RequestMethod.POST)
	public String removeItem(final Locale locale, final Model model,
			@ModelAttribute("cart") List<Pizza> cart, final String productName,
			final String username) {
		String ret = "redirect:/order";
		for (int i = 0; i < cart.size(); i++) {
			if (cart.get(i).getName().equals(productName)) {
				cart.remove(i);

				if (!cart.isEmpty()) {
					getCartPrice(model, cart);
				}

				break;
			}
		}

		if (cart.isEmpty()) {
			ret = "redirect:/pizza";
		} else {
			getUserData(username, model);
		}
		return ret;
	}

	private void getUserData(final String username, final Model model) {
		User user = new User();
		for (User userNow : userService.getRepository()) {
			if (userNow.getUser().equals(username)) {
				user.setUser(username);
				user.setAddress(userNow.getAddress());
				user.setCity(userNow.getCity());
				user.setName(userNow.getName());
				user.setZipcode(userNow.getZipcode());
				user.setPhone(userNow.getPhone());
			}
		}
		model.addAttribute("userData", user);
	}

	private void getCartPrice(final Model model, List<Pizza> cart) {
		double sum = 0;
		for (Pizza item : cart) {
			sum += item.getPrice();
		}
		model.addAttribute("totalPrice", new DecimalFormat("##.##").format(sum));
	}

	private void orderPut(List<Pizza> cart, OrderData orderData) {
		Order order = new Order(orderData, cart, new Date());
		orderService.addOrder(order);
		cart.clear();
	}
}
