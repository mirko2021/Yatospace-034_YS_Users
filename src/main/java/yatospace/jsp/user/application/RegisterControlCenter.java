package yatospace.jsp.user.application;

import yatospace.jsp.user.controller.RegisterController;
import yatospace.jsp.user.io.UserStorage;

/**
 * Register controle center specification; 
 * @author MV
 * @version 1.0
 */
public interface RegisterControlCenter {
	public RegisterController getRegisterController(); 
	public UserStorage        getUserStorage();
}
