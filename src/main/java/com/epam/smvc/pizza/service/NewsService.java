package com.epam.smvc.pizza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.smvc.pizza.repository.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository repository;

	public NewsRepository getRepository() {
		return this.repository;
	}
}
