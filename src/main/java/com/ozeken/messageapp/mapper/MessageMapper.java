package com.ozeken.messageapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ozeken.messageapp.entity.Message;

@Mapper
public interface MessageMapper {
	
	// メッセージを全て取得するメソッド
	List<Message> getAllMessage();
	
	// メッセージを取得するメソッド
	Message getMessage(Long id);
	
	// メッセージを保存するメソッド
	void insertMessage(Message message);

	// メッセージを削除するメソッド
	void deleteMessage(Long id);

}
