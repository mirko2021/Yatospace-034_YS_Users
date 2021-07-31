package yatospace.jsp.user.web.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import yatospace.jsp.user.util.SessionRepresentation;
import yatospace.jsp.user.util.UserSessionRepresentation;
import yatospace.jsp.user.web.listener.SessionContollersListener;

/**
 * Bean for sesions listing. 
 * @author MV
 * @version 1.0
 */
public class SessionsBean implements Serializable{
	private static final long serialVersionUID = -2692941528282869810L;
	
	public List<SessionRepresentation> sessions(PaggingBean page){
		return SessionContollersListener.sessionStorage.list(page.getPageNo(), page.getPageSize()); 
	}
	
	public String username(SessionRepresentation session) {
		if(session instanceof UserSessionRepresentation) {
			UserSessionRepresentation usr = (UserSessionRepresentation) session;
			return usr.user(); 
		}
		return null;
	}
	
	public List<SessionRepresentation> sessionsLogged(HttpSession session, PaggingBean page){
		ArrayList<SessionRepresentation> list = new ArrayList<>();
		String username = (String) session.getAttribute("username"); 
		if(username==null) return list; 
		if(username.trim().length()==0) return list; 
		for(SessionRepresentation sessionRepresentation: SessionContollersListener.sessionStorage.list(page.getPageNo(), page.getPageSize())) {
			if(sessionRepresentation.isUserHttpSessionRepresentation())
				if(sessionRepresentation.asUserHttpSessionRepresentation().user().contentEquals(username)) list.add(sessionRepresentation); 
		}
		return list;
	}
}
