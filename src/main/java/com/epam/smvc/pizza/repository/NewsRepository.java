package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.News;

@Repository
public class NewsRepository {
	private List<News> news = new ArrayList<>();

	public List<News> getNews() {
		Collections.sort(news);
		Collections.reverse(news);
		return this.news;
	}

	public void addNews(final News newsItem) {
		this.news.add(newsItem);
	}
}
