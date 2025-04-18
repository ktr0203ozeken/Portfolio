package com.ozeken.messageapp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ozeken.messageapp.entity.Message;

@Mapper
public interface MessageMapper {
	
	//メッセージを全件取得
	List<Message> getAllMessages();
	
	//メッセージをIDで取得
	Message getMessage(@Param("messageId") long messageId);
	
	//メッセージを新規作成
	void insertMessage(@Param("message") Message message);
}