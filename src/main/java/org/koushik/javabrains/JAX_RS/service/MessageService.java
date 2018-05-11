package org.koushik.javabrains.JAX_RS.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.koushik.javabrains.JAX_RS.database.DatabaseClass;
import org.koushik.javabrains.JAX_RS.model.Message;

public class MessageService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();


	public MessageService() {
		messages.put(1L, new Message(1,"Hello World!","Koushik"));
		messages.put(2L, new Message(2,"Hello Jersy!","Koushik"));
	}

	public List<Message> getAllMessage() {

		return new ArrayList<Message>(messages.values());

	}
	
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	public Message removeMessage(long id){
		
		return messages.remove(id);
	}
	
	public Message addMessage(Message msg){
		msg.setId(messages.size()+1);
		messages.put(msg.getId(),msg);
		return msg;
	}
	
	public Message updateMessage(Message msg){
		if(msg.getId()<=0){
			return null;
		}
		messages.put(msg.getId(), msg);
		return msg;	
	}
	
	

	
	

}
