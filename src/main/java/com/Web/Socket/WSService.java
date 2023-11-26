package com.Web.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WSService {
	
	private final SimpMessagingTemplate messagingTemplate;
	@Autowired
	public NotificationService notificationService;
	@Autowired
	public WSService(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate= messagingTemplate;
	}
	
	public void notifyFronted(String message) {
		ResponseMessage response= new ResponseMessage(message);
		notificationService.sendGlobalNotification(); 
		messagingTemplate.convertAndSend("/topic/messages",response);
	}

}
