package com.ozeken.messageapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ozeken.messageapp.MessageService;

@Controller
public class MessageController {

	/* DI */
	@Autowired
	private MessageService messageService;

	// メッセージ送信フォームを表示する
	@GetMapping("/message/form")
	public String messageForm(@RequestParam(required = false) Long messageId,
			@RequestParam(required = false) String message, Model model) {

		model.addAttribute("messageId", messageId);
		model.addAttribute("message", message);

		return "message-form";
	}

	// メッセージを送信する
	@PostMapping("/message/send")
	public String sendMessage(@RequestParam String message, RedirectAttributes redirectAttributes) {
		// バリデーションチェック
		if (message == null || message.trim().isEmpty()) {
			redirectAttributes.addFlashAttribute("error", "メッセージは必須です");
			return "redirect:/message/form";
		}

		try {
			long messageId = messageService.sendMessage(message);
			System.out.println("メッセージID: " + messageId + "  メッセージ: " + message);
			redirectAttributes.addAttribute("messageId", messageId);
			redirectAttributes.addAttribute("message", message);
			return "redirect:/message/form";
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("error", "メッセージの送信に失敗しました。再試行してください。");
			return "redirect:/message/form";
		}
	}

	// メッセージを取得する
	@GetMapping("/message/get")
	public String getMessage(long messageId) {
		String message = messageService.getMessage(messageId);
		System.out.println("メッセージID: " + messageId + "  メッセージ: " + message);
		// フォームにリダイレクト
		return "redirect:/message/form";
	}
}