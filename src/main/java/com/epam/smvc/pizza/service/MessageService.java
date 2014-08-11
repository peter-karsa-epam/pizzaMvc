package com.epam.smvc.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.smvc.pizza.domain.Message;
import com.epam.smvc.pizza.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository repository;

	public List<Message> getRepository() {
		return repository.getMessages();
	}

	public void addRepository(final Message msg) {
		this.repository.addMessages(msg);
	}
}
