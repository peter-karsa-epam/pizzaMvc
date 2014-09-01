package com.epam.smvc.pizza.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({ "cart", "orderData" })
public class AdminController {

}
