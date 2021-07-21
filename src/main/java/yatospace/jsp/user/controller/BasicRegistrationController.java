package yatospace.jsp.user.controller;

import yatospace.jsp.user.event.BasicEventMap;
import yatospace.jsp.user.event.EventMap;
import yatospace.jsp.user.event.ParameterMap;
import yatospace.jsp.user.event.ParameterObject;
import yatospace.jsp.user.object.User;

/**
 * Register controller. 
 * @author MV
 * @version 1.0
 */
public class BasicRegistrationController implements RegisterController{
	private BasicEventMap preregister = new BasicEventMap(); 
	private BasicEventMap onregister  = new BasicEventMap(); 
	private BasicEventMap postregister = new BasicEventMap();
	private BasicEventMap prederegister = new BasicEventMap(); 
	private BasicEventMap onderegister = new BasicEventMap();
	private BasicEventMap postderegister = new BasicEventMap(); 
	private BasicEventMap preupdate = new BasicEventMap(); 
	private BasicEventMap onupdate = new BasicEventMap(); 
	private BasicEventMap postupdate = new BasicEventMap(); 
	private BasicEventMap precheck = new BasicEventMap();
	private BasicEventMap oncheck = new BasicEventMap(); 
	private BasicEventMap postcheck = new BasicEventMap(); 
	
	@Override
	public ParameterMap register(User user) {
		ParameterMap map = new ParameterMap(); 
		ParameterObject usernameParam = new ParameterObject("user");  
		usernameParam.setParameterClazz(User.class);
		usernameParam.setInputProvider(this);
		usernameParam.setParameterValue(user);
		map.add(usernameParam);
		preregister.run(map);
		onregister.run(map); 
		postregister.run(map);
		return map;
	}

	@Override
	public ParameterMap deregister(String username) {
		ParameterMap map = new ParameterMap();
		ParameterObject usernameParam = new ParameterObject("username");  
		usernameParam.setParameterClazz(String.class);
		usernameParam.setInputProvider(this);
		usernameParam.setParameterValue(username);
		map.add(usernameParam);
		prederegister.run(map);
		onderegister.run(map);
		postderegister.run(map); 
		return map;
	}

	@Override
	public ParameterMap upadte(String username, User user) {
		ParameterMap map = new ParameterMap(); 
		ParameterObject userParam = new ParameterObject("user");
		ParameterObject usernameParam = new ParameterObject("username");
		userParam.setParameterClazz(User.class);
		userParam.setInputProvider(this);
		userParam.setParameterValue(user);
		usernameParam.setParameterClazz(String.class);
		usernameParam.setInputProvider(this);
		usernameParam.setParameterValue(username);
		map.add(usernameParam);
		preregister.run(map);
		onregister.run(map); 
		postregister.run(map);
		return map;
	}
	
	@Override
	public ParameterMap check(String username, String password) {
		ParameterMap map = new ParameterMap(); 
		ParameterObject usernameParam = new ParameterObject("username"); 
		ParameterObject passwordParam = new ParameterObject("password"); 
		usernameParam.setParameterClazz(String.class);
		passwordParam.setParameterClazz(String.class);
		usernameParam.setInputProvider(this);
		passwordParam.setInputProvider(this);
		usernameParam.setParameterValue(username);
		passwordParam.setParameterValue(password);
		map.add(usernameParam);
		map.add(passwordParam);
		precheck.run(map);
		oncheck.run(map); 
		postcheck.run(map); 
		return map;
	}
	
	@Override
	public BasicEventMap preregister() {
		return preregister;
	}
	
	public BasicEventMap onregister() {
		return onregister; 
	}
	
	@Override
	public BasicEventMap postregister() {
		return postregister;
	}

	@Override
	public BasicEventMap prederegister() {
		return prederegister;
	}
	
	public BasicEventMap onderegister() {
		return onderegister; 
	}
	
	@Override
	public BasicEventMap postderegister() {
		return postderegister;
	}

	public EventMap onupdate() {
		return onupdate; 
	}
	
	@Override
	public EventMap preupdate() {
		return preupdate;
	}

	@Override
	public EventMap postupadte() {
		return postupdate;
	}

	public EventMap oncheck() {
		return oncheck; 
	}
	
	@Override
	public EventMap precheck() {
		return precheck;
	}

	@Override
	public EventMap postcheck() {
		return postcheck;
	}
}
