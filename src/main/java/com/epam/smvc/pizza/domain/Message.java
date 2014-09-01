package com.epam.smvc.pizza.domain;

import java.util.Date;

public class Message implements Comparable<Message> {
	private String name;
	private Date date;
	private String message;

	public Message() {

	}

	public Message(final String title, final String content) {
		this.name = title;
		this.message = content;
		this.date = new Date();
	}

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
