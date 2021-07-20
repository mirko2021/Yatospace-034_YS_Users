package yatospace.jsp.user.controller;

import javax.servlet.http.HttpSession;

import yatospace.jsp.user.event.BasicEventMap;
import yatospace.jsp.user.event.EventMap;
import yatospace.jsp.user.event.ParameterMap;
import yatospace.jsp.user.event.ParameterObject;

/**
 * Basic implementation of logon controller. 
 * @author MV
 * @version 1.0
 */
public class BasicLogonController implements LogonController{
	private BasicEventMap onlogin = new BasicEventMap(); 
	private BasicEventMap prelogin = new BasicEventMap(); 
	private BasicEventMap postlogin = new BasicEventMap();
	private BasicEventMap onlogout = new BasicEventMap(); 
	private BasicEventMap prelogout = new BasicEventMap(); 
	private BasicEventMap postlogout = new BasicEventMap();
	private BasicEventMap onlogoutall = new BasicEventMap(); 
	private BasicEventMap prelogoutall = new BasicEventMap(); 
	private BasicEventMap postlogoutall = new BasicEventMap(); 
	
	@Override
	public void login(HttpSession session, String username, String password) {
		ParameterMap map = new ParameterMap(); 
		ParameterObject usernameParam = new ParameterObject("username"); 
		ParameterObject passwordParam = new ParameterObject("password"); 
		ParameterObject httpSessionParam = new ParameterObject("session"); 
		usernameParam.setParameterClazz(String.class);
		passwordParam.setParameterClazz(String.class);
		httpSessionParam.setParameterClazz(HttpSession.class);
		usernameParam.setInputProvider(this);
		passwordParam.setInputProvider(this);
		httpSessionParam.setInputProvider(httpSessionParam);
		usernameParam.setParameterValue(username);
		passwordParam.setParameterValue(password);
		httpSessionParam.setParameterValue(httpSessionParam);
		map.add(usernameParam);
		map.add(passwordParam);
		prelogin.run(map);
		onlogin.run(map); 
		postlogin.run(map); 
	}

	@Override
	public void logout(HttpSession session) {
		ParameterMap map = new ParameterMap(); 
		ParameterObject usernameParam = new ParameterObject("session"); 
		usernameParam.setInputProvider(this);
		prelogout.run(map); 
		onlogout.run(map);
		postlogout.run(map); 
	}

	@Override
	public void logoutAll(String username) {
		ParameterMap map = new ParameterMap(); 
		ParameterObject usernameParam = new ParameterObject("username");  
		usernameParam.setInputProvider(this);
		prelogoutall.run(map);
		onlogoutall.run(map); 
		postlogoutall.run(map);
	}

	@Override
	public BasicEventMap prelogin() {
		return prelogin;
	}

	public BasicEventMap onlogin() {
		return onlogin; 
	}
	
	@Override
	public BasicEventMap postlogin() {
		return postlogin;
	}

	@Override
	public BasicEventMap prelogout() {
		return prelogout;
	}

	public BasicEventMap onlogout() {
		return onlogout; 
	}
	
	@Override
	public BasicEventMap postlogout() {
		return postlogout;
	}

	@Override
	public EventMap prelogoutAll() {
		return prelogoutall;
	}
	
	public EventMap onlogoutAll() {
		return onlogoutall; 
	}
	
	@Override
	public EventMap postlogoutAll() {
		return postlogoutall;
	}
}
