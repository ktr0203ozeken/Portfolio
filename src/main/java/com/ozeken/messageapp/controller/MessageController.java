package com.ozeken.messageapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ozeken.messageapp.entity.Message;
import com.ozeken.messageapp.mapper.MessageMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MessageController {
	
	//メッセージフォームのURLを指定
	@GetMapping("/message/form")
	public String showMessageForm() {
		return "message/form";
	}
	
	//DI
	private final MessageMapper messageMapper;
	
	//メッセージを全て取得する
	@GetMapping("/list")
	public String showAllMessages(Model model) {
		model.addAttribute("successmessage", "一覧表示");
		model.addAttribute("messages", messageMapper.getAllMessage());
		return "message/success";
	}
	
	//特定のIDを持つメッセージを取得する
	@GetMapping("/detail/{id}")
	//@PathVariableでURLの変数を取得
	public String showMessage(@PathVariable Long id, Model model) {
		model.addAttribute("successmessage", "詳細表示");
		model.addAttribute("message", messageMapper.getMessage(id));
		return "message/success";
	}
	
	// メッセージを新規作成（フォームからのPOST）
	@PostMapping("/message/send")
	public String createMessage(@RequestParam("message") String content, Model model) {
	    Message message = new Message();
	    message.setContent(content);
	    messageMapper.insertMessage(message);
	    model.addAttribute("successmessage", "メッセージを保存しました");
	    return "message/success";
	}
	//メッセージを削除する
	@GetMapping("/delete/{id}")
	public String deleteMessage(@PathVariable Long id, Model model) {
		messageMapper.deleteMessage(id);
		model.addAttribute("successmessage", "メッセージを削除しました");
		return "message/success";
	}
	
}
