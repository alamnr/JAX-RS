package org.koushik.javabrains.JAX_RS.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.koushik.javabrains.JAX_RS.database.DatabaseClass;
import org.koushik.javabrains.JAX_RS.model.Comment;
import org.koushik.javabrains.JAX_RS.model.ErrorMessage;
import org.koushik.javabrains.JAX_RS.model.Message;

public class CommentService {
	
	private Map<Long,Message> messages = DatabaseClass.getMessages();


	
	public List<Comment> getAllComment(long messageId) {
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		return new ArrayList<Comment>(comments.values());

	}
	
	public Comment getComment(long messageId,long commentId){
		ErrorMessage ErrorMessage = new ErrorMessage("Not Found",404,"http://javabrain.koushik.org");
		Response response=  Response.status(Status.INTERNAL_SERVER_ERROR)
						.entity(ErrorMessage).build();
		
		Message msg= messages.get(messageId);
		if(msg==null)
		{
			
			throw new WebApplicationException(response);
		}
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		Comment comment = comments.get(commentId);
		if(comment == null){
			//throw new WebApplicationException(response);
			throw new NotFoundException(response);
		}
		return comments.get(commentId);
	}
	
	
	public Comment addComment(long messageId, Comment comment){
		
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		comment.setId(comments.size()+1);
		comments.put(comment.getId(),comment);
		return comment;
	}
	
	public Comment updateComment(long messageId, Comment comment){
		Map<Long,Comment> comments = messages.get(messageId).getComments();
		if(comment.getId()<=0){
			return null;
		}
		comments.put(comment.getId(), comment);
		
		return comment;	
	}
	
	public Comment removeComment(long mesageId, long commentId){
		Map<Long,Comment> comments = messages.get(mesageId).getComments();
		return comments.remove(commentId);
	}
	
	

}
