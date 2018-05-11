package org.koushik.javabrains.JAX_RS.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.koushik.javabrains.JAX_RS.model.Message;
import org.koushik.javabrains.JAX_RS.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	// @Produces(MediaType.TEXT_PLAIN)
	//@Produces(MediaType.APPLICATION_XML)
	public List<Message> getMessages(@QueryParam("year") int year, 
			@QueryParam("start")int start, @QueryParam("size")int size) {
		if(start>0 && size>=0){
			return messageService.getAllMessagesPaginated(start, size);
		}
		if(year >0){
			return messageService.getAllMessageForYear(year);
		}
		return messageService.getAllMessage();
	}
	
	@POST
	public Message addMessage(Message msg) {
		
		return messageService.addMessage(msg);
	}
	
	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id,Message msg) {
		msg.setId(id);
		
		return messageService.updateMessage(msg);
	}
	
	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		
		 messageService.removeMessage(id);
	}


	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getMessage(@PathParam("messageId") long id) {
		
		return messageService.getMessage(id);
	}
	
	

}
