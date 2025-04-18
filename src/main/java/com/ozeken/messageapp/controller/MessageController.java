package com.ozeken.messageapp.controller;

import java.sql.Timestamp;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozeken.messageapp.entity.Message;
import com.ozeken.messageapp.mapper.MessageMapper;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MessageController {

	// DI
	private final MessageMapper messageMapper;

	// メッセージ送信フォームを表示する
	@GetMapping("/message/form")
	public String messageForm(Model model) {
		// 空のMessageオブジェクトを作成
		model.addAttribute("messageForm", new Message());
		return "message/form";
	}
	// すべてのメッセージを取得
	@GetMapping("/message/list")
	public String getAllMessage(Model model) {
		//DBからselect
		model.addAttribute("messages", messageMapper.getAllMessages());
		return "message/success";
	}

	// メッセージを送信する
	@PostMapping("/message/send")
	public String sendMessage(@Valid @ModelAttribute("messageForm") Message message,
	                          BindingResult result,
	                          Model model,
	                          RedirectAttributes redirectAttributes) {
	    if (result.hasErrors()) {
	    	result.getAllErrors().forEach(error -> System.out.println("→ " + error.getDefaultMessage()));
	        model.addAttribute("messageForm", message); 
	        return "message/form";
	    }

	    message.setCreatedAt(new Timestamp(System.currentTimeMillis()));
	    messageMapper.insertMessage(message);

	    redirectAttributes.addFlashAttribute("messageId", message.getMessageId());
	    redirectAttributes.addFlashAttribute("message", message.getContent());
	    redirectAttributes.addFlashAttribute("createdAt", message.getCreatedAt());

	    return "redirect:/message/form";
	}


}