package com.Web.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class MessageController {
	@Autowired
	public NotificationService notificationService;
	@MessageMapping("/message")
	@SendTo("/topic/messages")
	public ResponseMessage getMessage(Message message) throws InterruptedException{
		Thread.sleep(1000);
		notificationService.sendGlobalNotification();
		return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessageContent()));
	}

}
