package com.epam.smvc.pizza.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.epam.smvc.pizza.domain.Message;

@Repository
public class MessageRepository {
	private List<Message> messages = new ArrayList<>();
	
	//just for test
	public MessageRepository() {
		messages.add(new Message("Mike McKenzie","Best pizza in my life!"));
		messages.add(new Message("Chris","Best pizza in my life!"));
		messages.add(new Message("Mr.Sulu","Best pizza in my life!"));
	}

	public List<Message> getMessages() {
		Collections.sort(messages);
		Collections.reverse(messages);
		return this.messages;
	}

	public void addMessages(final Message messages) {
		this.messages.add(messages);
	}
}
