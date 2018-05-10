package org.koushik.javabrains.JAX_RS.service;

import java.util.ArrayList;
import java.util.List;

import org.koushik.javabrains.JAX_RS.model.Message;

public class MessageService {
	
 public List<Message> getAllMessage(){
	 
	 Message m1= new Message(1L,"Hello World!", "Koushik");
	 Message m2= new Message(2L,"Hello Jersy!", "Koushik");
	 
	 List<Message> list = new ArrayList<>();
	 
	 list.add(m1);
	 list.add(m2); 
	 
	 return list;
	 
 }
 
}
