package com.Web.Socket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class WSController {
	@Autowired
	public WSService service;
	@Autowired
	public MessageRepository repo;
	@GetMapping("/index")
	public String index(Model model) {
		List<Message> message= repo.findAll();
		model.addAttribute("message", message);
		return "index";
	}
	@PostMapping("/message")
	public String envoi(@RequestParam("message") String message) {
		Message mes = new Message();
		mes.setMessageContent(message);
		repo.save(mes);
		return "redirect:/index";
	}
	@PostMapping("/send-message")
	public void sendMessage(@RequestBody Message message) {
		service.notifyFronted(message.getMessageContent());
	}

	@GetMapping("/do")
	public String dosss() {
		return "/fi/do";
	}
}
