package com.epam.smvc.pizza.domain;

import java.util.Date;

public class MainMessage {
	private String title;
	private Date dateAdded;
	private String content;

	public String getTitle() {
		return title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(final Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getContent() {
		return content;
	}

	public void setContent(final String content) {
		this.content = content;
	}
}
