package yatospace.jsp.user.web.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import yatospace.jsp.user.toolkit.ContentEncoding;

/**
 * Информације о стању у оквиору извршавања станица. 
 * @author MV
 * @version 1.0
 */
public class Status implements Serializable{
	private static final long serialVersionUID = 333614512187473906L;
	
	private boolean success = true; 
	private List<String> messages = new ArrayList<>();
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<String> getMessages() {
		return new ArrayList<>(messages);
	}
	public void setMessages(List<String> messages) {
		if(messages==null) messages = new ArrayList<>(); 
		this.messages = new ArrayList<>(messages);
	} 
	public List<String> liveMessages() {
		return messages;
	}
	public List<String> displayMessages() {
		ArrayList<String> result = new ArrayList<>(); 
		for(String message: messages)
			result.add(ContentEncoding.encodeHTML(message));
		return messages;
	}
}
