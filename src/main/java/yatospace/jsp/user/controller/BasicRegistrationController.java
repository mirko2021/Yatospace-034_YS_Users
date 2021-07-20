package yatospace.jsp.user.controller;

import yatospace.jsp.user.event.BasicEventMap;
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
	
	@Override
	public void register(User user) {
		ParameterMap map = new ParameterMap(); 
		ParameterObject usernameParam = new ParameterObject("user");  
		usernameParam.setParameterClazz(User.class);
		usernameParam.setInputProvider(this);
		usernameParam.setParameterValue(user);
		map.add(usernameParam);
		preregister.run(map);
		onregister.run(map); 
		postregister.run(map); 
	}

	@Override
	public void deregister(String username) {
		ParameterMap map = new ParameterMap();
		ParameterObject usernameParam = new ParameterObject("username");  
		usernameParam.setParameterClazz(String.class);
		usernameParam.setInputProvider(this);
		usernameParam.setParameterValue(username);
		map.add(usernameParam);
		prederegister.run(map);
		onderegister.run(map);
		postderegister.run(map); 
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
}
