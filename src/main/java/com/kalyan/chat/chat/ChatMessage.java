package com.kalyan.chat.chat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class ChatMessage {
	
	private String content;
	private String sender;
	private MessageType type;

}
