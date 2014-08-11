package com.epam.smvc.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.smvc.pizza.domain.News;
import com.epam.smvc.pizza.repository.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository repository;

	public List<News> getRepository() {
		return this.repository.getNews();
	}

	public void addRepository(final News news) {
		this.repository.addNews(news);
	}
}
