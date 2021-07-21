package yatospace.jsp.user.controller;

import yatospace.jsp.user.event.EventMap;
import yatospace.jsp.user.event.ParameterMap;
import yatospace.jsp.user.object.User;

/**
 * Register controller specification; 
 * @author MV
 * @version 1.0
 */
public interface RegisterController {
	public ParameterMap register(User user);
	public ParameterMap deregister(String username); 
	public ParameterMap upadte(String username, User user); 
	public ParameterMap check(String username, String password);
	public EventMap preregister(); 
	public EventMap postregister(); 
	public EventMap prederegister(); 
	public EventMap postderegister(); 
	public EventMap preupdate(); 
	public EventMap postupadte(); 
	public EventMap precheck();
	public EventMap postcheck();
}
