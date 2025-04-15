package com.ozeken.messageapp;

public class MainTest {
    public static void main(String[] args) {

        //MessageServiceImpl の動作確認
    	MessageService messageService  =new MessageServiceImpl();

        //メッセージの送信
        long messageId=messageService.sendMessage("こんにちは");
        System.out.println(messageId);

        //メッセージの取得
        String message=messageService .getMessage(1);
        System.out.println(message);
       
        //メッセージの削除
        messageService .deleteMessage(1);

        //削除後のメッセージ取得の動作確認
        message=messageService .getMessage(messageId);
        System.out.println(message);
    }
}
