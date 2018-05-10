package org.koushik.javabrains.JAX_RS.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.service.MessageService;

@Path("/messages")
public class MessageResource {
	
	MessageService messageService =  new MessageService();

	
	@GET
	//@Produces(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(){
		return messageService.getAllMessage();
	}

}
