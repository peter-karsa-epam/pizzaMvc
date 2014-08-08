package com.epam.smvc.pizza.domain;

import java.util.Date;

public class Message implements Comparable<Message> {
	private String name;
	private Date date;
	private String message;

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	@Override
	public int compareTo(final Message o) {
		return this.getDate().compareTo(o.getDate());
	}
}
