//package com.example.retrospect.user.controller;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.Payload;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
//
//public class ChatController{
//
//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public  ChatMessage sendMessage(@Payload ChatMessage chatMessage){
//      return chatMessage;
//    }
//    public  ChatMessage addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor simpMessageHeaderAccessor){
//        simpMessageHeaderAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//
//    }
//}
