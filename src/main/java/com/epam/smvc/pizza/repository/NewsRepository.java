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

	// just for test
	public NewsRepository() {
		news.add(new News(
				"Spring MVC",
				"While somewhat flexible, the mechanism to determine this target"
						+ " URL does not allow the determination to be done programatically"
						+ " – so we’re going to implement the interface and provide a custom"
						+ " implementation of the success handler. This implementation is going"
						+ " to determine the URL to redirect the user to after login based on the"
						+ " role of the user:"));
	}
}
