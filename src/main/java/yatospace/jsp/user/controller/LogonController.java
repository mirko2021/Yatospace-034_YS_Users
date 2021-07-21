package yatospace.jsp.user.controller;

import javax.servlet.http.HttpSession;

import yatospace.jsp.user.event.EventMap;
import yatospace.jsp.user.event.ParameterMap;

/**
 * Logon controller specification. 
 * @author MV
 * @version 1.0
 */
public interface LogonController {
	public ParameterMap login(HttpSession session, String username, String password); 
	public ParameterMap logout(HttpSession session);
	public ParameterMap logoutAll(String username);
	public ParameterMap check(String username, String password);
	public EventMap prelogin(); 
	public EventMap postlogin(); 
	public EventMap prelogout(); 
	public EventMap postlogout(); 
	public EventMap prelogoutAll(); 
	public EventMap postlogoutAll(); 
	public EventMap precheck(); 
	public EventMap postcheck(); 
}
