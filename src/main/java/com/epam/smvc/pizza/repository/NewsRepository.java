package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.News;

@Repository
public class NewsRepository {
	private List<News> news = new ArrayList<News>();

	public List<News> getNews() {
		return news;
	}

	public void setNews(final List<News> news) {
		this.news = news;
	}
}
