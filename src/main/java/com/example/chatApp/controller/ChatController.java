package com.example.chatApp.controller;

import com.example.chatApp.Model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @MessageMapping("/sendMessage") // Handle messages sent to /app/sendMessage
    @SendTo("/topic/public") // Broadcast messages to /topic/public
    public ChatMessage sendMessage(ChatMessage message) {
        return message; // Broadcast the received message
    }

    @MessageMapping("/addUser") // Handle user joining
    @SendTo("/topic/public")
    public ChatMessage addUser(ChatMessage message) {
        message.setType("JOIN");
        return message;
    }
}
