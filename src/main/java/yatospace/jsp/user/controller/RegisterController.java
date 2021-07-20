package yatospace.jsp.user.controller;

import yatospace.jsp.user.event.EventMap;
import yatospace.jsp.user.object.User;

/**
 * Register controller specification; 
 * @author MV
 * @version 1.0
 */
public interface RegisterController {
	public void register(User user);
	public void deregister(String username); 
	public EventMap preregister(); 
	public EventMap postregister(); 
	public EventMap prederegister(); 
	public EventMap postderegister(); 
}
