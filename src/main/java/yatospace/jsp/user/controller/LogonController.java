package yatospace.jsp.user.controller;

import javax.servlet.http.HttpSession;

import yatospace.jsp.user.event.EventMap;

/**
 * Logon controller specification. 
 * @author MV
 * @version 1.0
 */
public interface LogonController {
	public void login(HttpSession session, String username, String password); 
	public void logout(HttpSession session);
	public void logoutAll(String username);
	public EventMap prelogin(); 
	public EventMap postlogin(); 
	public EventMap prelogout(); 
	public EventMap postlogout(); 
	public EventMap prelogoutAll(); 
	public EventMap postlogoutAll(); 
}
