package com.ozeken.messageapp.entity;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Message {

	// 送信id
	private Long messageId;

	// 送信するメッセージ
	@NotBlank(message = "メッセージは必須です")
	@Pattern(regexp = ".*[^\\s　].*", message = "空白だけの入力はできません")
	private String content;

	// 送信時刻
	private Timestamp createdAt;

}