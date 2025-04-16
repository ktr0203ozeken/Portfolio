package com.ozeken.messageapp.entity;

import lombok.Data;

@Data
public class Message {

	// メッセージID
	private Long id;

	// メッセージの中身
	private String content;
}
