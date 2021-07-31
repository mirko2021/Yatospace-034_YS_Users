package yatospace.jsp.user.web.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import yatospace.jsp.user.controller.LogonController;
import yatospace.jsp.user.util.SessionRepresentation;
import yatospace.jsp.user.web.listener.SessionContollersListener;

/**
 * Bean for user logon. 
 * @author MV
 * @version 1.0
 */
public class LogonBean implements Serializable{
	private static final long serialVersionUID = -7332876634545457235L;
	private String username = ""; 
	private String password = "";
	private String logged = ""; 
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(username==null) username = ""; 
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password==null) password = ""; 
		this.password = password;
	} 
	
	public void reset() {
		username = ""; 
		password = "";
	}
	
	public void resetLogged() {
		logged = ""; 
	}
	
	public String getLogged() {
		return logged; 
	}
	
	public boolean isLogged() {
		return logged.trim().length() == 0; 
	}
	
	public void setLogged(String logged) {
		if(logged==null) throw new NullPointerException(); 
		this.logged = logged;
	}
	
	public void test(HttpServletRequest request, PageExecutingBean pageExcecutingBean) {
		try {
			if(pageExcecutingBean.getStatus().liveMessages().size()==0) pageExcecutingBean.getStatus().liveMessages().add(""); 
			LogonController controller = (LogonController) SessionContollersListener.getLogonControlCenter(request.getSession()).getLogonController(); 
			boolean result = (boolean) controller.check(request.getParameter("username"), request.getParameter("password")).get("result").getParameterValue();
			if(!result) throw new RuntimeException();
			pageExcecutingBean.getStatus().liveMessages().set(0,"Лозинка и корисничко име задовољавају.");
		}catch(Exception ex) {
			pageExcecutingBean.getStatus().liveMessages().set(0,"Лозинка и корисничко име не задовољавају.");
		}
	}
	
	public void login(HttpServletRequest request, PageExecutingBean pageExcecutingBean) {
		try {
			if(pageExcecutingBean.getStatus().liveMessages().size()==0) pageExcecutingBean.getStatus().liveMessages().add(""); 
			LogonController controller = (LogonController) SessionContollersListener.getLogonControlCenter(request.getSession()).getLogonController(); 
			username = request.getParameter("username"); 
			password = request.getParameter("password"); 
			if(username==null) username = ""; 
			if(password==null) password = "";
			boolean success = (boolean) controller.login(request.getSession(), username, password).get("success").getParameterValue();
			if(!success) throw new NullPointerException(); 
			logged = username; 
			password = ""; 
			pageExcecutingBean.getStatus().liveMessages().set(0, "Пријава корисника на систем је успјела."); 
		}catch(Exception ex) {
			pageExcecutingBean.getStatus().liveMessages().set(0, "Пријава корисника на систем није успјела."); 
		}
	}
	
	public void logout(HttpServletRequest request, PageExecutingBean pageExecutingBean) {
		try {
			if(pageExecutingBean.getStatus().liveMessages().size()==0) pageExecutingBean.getStatus().liveMessages().add(""); 
			username = request.getParameter("username"); 
			LogonController controller = (LogonController) SessionContollersListener.getLogonControlCenter(request.getSession()).getLogonController();  
			controller.logout(request.getSession()); 
			logged = ""; 
			username = ""; 
			password = ""; 
			pageExecutingBean.getStatus().liveMessages().set(0, "Одјава корисника са система је успјела."); 
		}catch(Exception ex) {
			pageExecutingBean.getStatus().liveMessages().set(0, "Одјава корисника са система није успјела."); 
		}
	}
	
	public void logoutSession(HttpServletRequest request, PageExecutingBean pageExecutingBean) {
		try {
			if(pageExecutingBean.getStatus().liveMessages().size()==0) pageExecutingBean.getStatus().liveMessages().add(""); 
			String sessionId = request.getParameter("user_sessions_logout_data");
			SessionRepresentation representation = SessionContollersListener.sessionStorage.get(sessionId); 
			LogonController controller = (LogonController) SessionContollersListener.getLogonControlCenter(request.getSession()).getLogonController();  
			LogonBean logonBean = (LogonBean) representation.asBasicHttpSessionRepresentation().getSession().getAttribute("logonBean"); 
			logonBean.logged = ""; 
			logonBean.username = ""; 
			logonBean.password = "";
			controller.logout(representation.asBasicHttpSessionRepresentation().getSession()); 
			pageExecutingBean.getStatus().liveMessages().set(0, "Одјава корисника са система је успјела."); 
		}catch(Exception ex) {
			pageExecutingBean.getStatus().liveMessages().set(0, "Одјава корисника са система није успјела."); 
		}
	}
	
	public void logoutLogged(HttpServletRequest request, PageExecutingBean pageExecutingBean) {
		try {
			if(pageExecutingBean.getStatus().liveMessages().size()==0) pageExecutingBean.getStatus().liveMessages().add(""); 
			username = logged;  
			LogonController controller = (LogonController) SessionContollersListener.getLogonControlCenter(request.getSession()).getLogonController();  
			controller.logout(request.getSession()); 
			logged = ""; 
			username = ""; 
			password = ""; 
			pageExecutingBean.getStatus().liveMessages().set(0, "Одјава корисника са система је успјела."); 
		}catch(Exception ex) {
			pageExecutingBean.getStatus().liveMessages().set(0, "Одјава корисника са система није успјела."); 
		}
	}
	
	public void logoutAll(HttpServletRequest request, PageExecutingBean pageExecutingBean) {
		try {
			if(pageExecutingBean.getStatus().liveMessages().size()==0) pageExecutingBean.getStatus().liveMessages().add(""); 
			username = logged; 
			if(username==null) return; 
			LogonController controller = (LogonController) SessionContollersListener.getLogonControlCenter(request.getSession()).getLogonController();  
			controller.logoutAll(logged); 
			logged = ""; 
			username = ""; 
			password = ""; 
			pageExecutingBean.getStatus().liveMessages().set(0, "Одјава корисника са система је успјела."); 
		}catch(Exception ex) {
			pageExecutingBean.getStatus().liveMessages().set(0, "Одјава корисника са система није успјела."); 
		}
	}
}
