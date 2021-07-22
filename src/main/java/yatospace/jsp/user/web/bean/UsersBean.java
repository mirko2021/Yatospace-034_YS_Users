package yatospace.jsp.user.web.bean;

import java.io.Serializable;
import java.util.List;

import yatospace.jsp.user.object.User;
import yatospace.jsp.user.web.listener.SessionContollersListener;

/**
 * Bean for user listing. 
 * @author MV
 * @version 1.0
 */
public class UsersBean implements Serializable{
	private static final long serialVersionUID = 606901154037340567L;
	
	public List<User> users(PaggingBean page){
		return SessionContollersListener.userStorage.list(page.getPageNo(), page.getPageSize()); 
	}
}
