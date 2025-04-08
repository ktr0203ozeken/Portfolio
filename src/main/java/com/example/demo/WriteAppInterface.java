package com.example.demo;

public interface WriteAppInterface {

    //オーバーライドする必要があるためこのくらいでよい
    //双方向は別のインターフェイスに

    //メッセージをセットし送る
    long sendMessage(String message); 

    //メッセージを取得
    String getMessage(long messageId); 

    //メッセージを削除
    void deleteMessage(long messageId); 
    
}