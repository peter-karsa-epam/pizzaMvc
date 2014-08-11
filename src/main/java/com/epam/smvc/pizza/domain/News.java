package com.epam.smvc.pizza.domain;

import java.util.Date;

public class News implements Comparable<News> {
	private String title;
	private String content;
	private Date date;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDateAdded(final Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(final News o) {
		return this.getDate().compareTo(o.getDate());
	}
}
