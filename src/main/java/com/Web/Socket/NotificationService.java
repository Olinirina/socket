package com.Web.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	private final SimpMessagingTemplate messagingTemplate;
	public NotificationService(SimpMessagingTemplate messagingTemplate) {
		this.messagingTemplate= messagingTemplate;
	}
	public void sendGlobalNotification() {
		ResponseMessage message= new ResponseMessage("Global notification");
		messagingTemplate.convertAndSend("/topic/global-notification",message);
	}

}
