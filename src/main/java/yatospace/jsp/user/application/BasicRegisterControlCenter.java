package yatospace.jsp.user.application;

import yatospace.jsp.user.controller.BasicRegistrationController;
import yatospace.jsp.user.controller.RegisterController;
import yatospace.jsp.user.engine.AuthenticationEngine;
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
				synchronized(authenticationEngine) {
					authenticationEngine.storePassword(user.getPassword()); 
					user.setPassword(authenticationEngine.passwordRecord());
					userStorage.add(user); 
				}
			}, "register");
			realController.onderegister().addLast(params->{
				String username = (String) params.get("username").getParameterValue(); 
				userStorage.remove(username); 
			}, "deregister");
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
