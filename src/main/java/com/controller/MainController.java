package com.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.User;
import com.entity.UserMessage;
import com.repos.MessageRepo;

@Controller
public class MainController {
	@Autowired
	private MessageRepo messageRepo;

	@GetMapping("/")
	public String greeting(Map<String, Object> model) {

		return "greet";
	}

	@GetMapping("/mainpage")
	public String messageList(Map<String, Object> model) {
		Iterable<com.entity.UserMessage> messages = messageRepo.findAll();
		model.put("messages", messages);

		return "mainpage";
	}

	@PostMapping("/mainpage")
	public String addMessage(@AuthenticationPrincipal User user, @RequestParam String text, Map<String, Object> model) {
		UserMessage message = new UserMessage(text, user);
		messageRepo.save(message);

		Iterable<com.entity.UserMessage> messages = messageRepo.findAll();
		model.put("messages", messages);
		return "mainpage";
	}

	/*
	 * @PostMapping("usname") public String Ugreeting(@RequestParam(name = "usname")
	 * String usname, Map<String, Object> model) { model.put("name", usname); return
	 * "greet"; }
	 */

	@PostMapping("filter")
	public String filterMessage(@RequestParam String filter, Map<String, Object> model) {
		Iterable<UserMessage> messages;

		if (!filter.isEmpty()) {
			messages = messageRepo.findByText(filter);
		} else
			messages = messageRepo.findAll();

		model.put("messages", messages);

		return "mainpage";
	}
}
