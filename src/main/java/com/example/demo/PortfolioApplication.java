package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortfolioApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }

    // 依存性をDIで注入
    @Autowired
    private MessageService messageService;

    @Override
    public void run(String... args) throws Exception {
    	
        long messageId;
        
        //メッセージの送信
        messageId=messageService.sendMessage("こんにちは");
        System.out.println(messageId);

        //メッセージの受け取り
        String message = messageService.getMessage(messageId);
        System.out.println(message);

        // メッセージ削除
        messageService.deleteMessage(messageId);
        
      //削除後のメッセージ取得の動作確認
        message=messageService.getMessage(messageId);
        System.out.println(message);
    }
}
