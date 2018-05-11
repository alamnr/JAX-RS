package org.koushik.javabrains.JAX_RS.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	// @Produces(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessage();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage(Message msg) {
		
		return messageService.addMessage(msg);
	}

	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long id) {
		
		return messageService.getMessage(id);
	}

}
