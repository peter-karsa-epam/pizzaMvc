package com.epam.smvc.pizza.domain;

import java.util.Date;

public class News implements Comparable<News> {
	private String title;
	private String content;
	private Date date;
	
	public News() {
		
	}

	public News(final String title, final String content) {
		this.title = title;
		this.content =content;
		this.date = new Date();
	}

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
