package yatospace.jsp.user.application;

import yatospace.jsp.user.controller.BasicRegistrationController;
import yatospace.jsp.user.controller.RegisterController;
import yatospace.jsp.user.engine.AuthenticationEngine;
import yatospace.jsp.user.event.ParameterObject;
import yatospace.jsp.user.event.ParameterType;
import yatospace.jsp.user.io.UserStorage;
import yatospace.jsp.user.object.User;

/**
 * Basic implementation of the register control center. 
 * @author MV
 * @version 1.0
 */
public class BasicRegisterControlCenter implements RegisterControlCenter{
	private RegisterController    registerController;
	private UserStorage           userStorage; 
	private AuthenticationEngine  authenticationEngine; 

	public BasicRegisterControlCenter(RegisterController registerController, UserStorage userStorage, AuthenticationEngine authEngine) {
		if(registerController==null) throw new NullPointerException();
		if(userStorage==null) throw new NullPointerException(); 
		if(authEngine==null) throw new NullPointerException();
		this.registerController = registerController; 
		this.userStorage = userStorage; 
		this.authenticationEngine = authEngine; 
		
		if(registerController instanceof BasicRegistrationController) {
			BasicRegistrationController realController = (BasicRegistrationController) registerController;
			realController.onregister().addLast(params->{
				User user = (User) params.get("user").getParameterValue(); 
				if(userStorage.get(user.getUsername())!=null) {
					ParameterObject success = new ParameterObject("success");
					success.setOutputProvider(this); 
					success.setParameterClazz(Boolean.class); 
					success.setParameterType(ParameterType.OUT); 
					success.setParameterValue(false); 
					params.add(success); 
				}else {
					synchronized(authenticationEngine) {
						authenticationEngine.storePassword(user.getPassword()); 
						user.setPassword(authenticationEngine.passwordRecord());
						userStorage.add(user); 
					}
					ParameterObject success = new ParameterObject("success");
					success.setOutputProvider(this); 
					success.setParameterClazz(Boolean.class); 
					success.setParameterType(ParameterType.OUT); 
					success.setParameterValue(true); 
					params.add(success); 
				}
			}, "register");
			realController.onderegister().addLast(params->{
				String username = (String) params.get("username").getParameterValue(); 
				if(userStorage.get(username)!=null) {
					userStorage.remove(username); 
					ParameterObject success = new ParameterObject("success");
					success.setOutputProvider(this); 
					success.setParameterClazz(Boolean.class); 
					success.setParameterType(ParameterType.OUT); 
					success.setParameterValue(true); 
					params.add(success); 
				}else {
					ParameterObject success = new ParameterObject("success");
					success.setOutputProvider(this); 
					success.setParameterClazz(Boolean.class); 
					success.setParameterType(ParameterType.OUT); 
					success.setParameterValue(false); 
					params.add(success); 
				}
			}, "deregister");
			realController.onupdate().addLast(params->{
				User user = (User) params.get("user").getParameterValue(); 
				String username = (String) params.get("username").getParameterValue(); 
				if(userStorage.get(username)==null) {
					ParameterObject success = new ParameterObject("success");
					success.setOutputProvider(this); 
					success.setParameterClazz(Boolean.class); 
					success.setParameterType(ParameterType.OUT); 
					success.setParameterValue(false); 
					params.add(success); 
					return; 
				}
				if(!user.getUsername().contentEquals(username))
				if(userStorage.get(user.getUsername())!=null) {
					ParameterObject success = new ParameterObject("success");
					success.setOutputProvider(this); 
					success.setParameterClazz(Boolean.class); 
					success.setParameterType(ParameterType.OUT); 
					success.setParameterValue(false); 
					params.add(success); 
					return;
				}
				User oldUser = userStorage.get(username); 
				oldUser.apply(user); 
				ParameterObject success = new ParameterObject("success");
				success.setOutputProvider(this); 
				success.setParameterClazz(Boolean.class); 
				success.setParameterType(ParameterType.OUT); 
				success.setParameterValue(true); 
				params.add(success); 
			}, "update");
			realController.oncheck().addLast(params->{
				String username = (String) params.get("username").getParameterValue(); 
				String password = (String) params.get("password").getParameterValue();
				User user = userStorage.get(username); 
				boolean res = true;
				if(user==null) {res = false;}
				else {
					synchronized(authenticationEngine) {
						authenticationEngine.storePassword(password);
						String rec = authenticationEngine.passwordRecord();
						res = rec.contentEquals(user.getPassword());
					}
				}
				ParameterObject result = new ParameterObject("result");
				result.setOutputProvider(this); 
				result.setParameterClazz(Boolean.class); 
				result.setParameterType(ParameterType.OUT); 
				result.setParameterValue(res); 
				params.add(result); 
			}, "check");
		}
	}
	
	@Override
	public RegisterController getRegisterController() {
		return registerController;
	}

	@Override
	public UserStorage getUserStorage() {
		return userStorage;
	}

	public AuthenticationEngine getAuthenticationEngine() {
		return authenticationEngine;
	}
}
