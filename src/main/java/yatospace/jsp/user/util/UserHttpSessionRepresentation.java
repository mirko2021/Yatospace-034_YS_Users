package yatospace.jsp.user.util;

import javax.servlet.http.HttpSession;

/**
 * Representation of the HTTP Session with functionals user data. 
 * @author MV
 * @value 1.0
 */
public class UserHttpSessionRepresentation extends BasicHttpSessionRepresentation implements UserSessionRepresentation{

	public UserHttpSessionRepresentation(HttpSession session) {
		super(session);
	}

	@Override
	public boolean hasUser() {
		String username = (String) getSession().getAttribute("username"); 
		if(username==null) return false; 
		if(username.trim().length()==0) return false; 
		return true;
	}

	@Override
	public String user() {
		String username = (String) getSession().getAttribute("username"); 
		if(username==null) return ""; 
		if(username.trim().length()==0) return ""; 
		return username; 
	}
	
}
