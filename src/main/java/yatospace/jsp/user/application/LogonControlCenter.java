package yatospace.jsp.user.application;

import yatospace.jsp.user.controller.LogonController;
import yatospace.jsp.user.controller.RegisterController;
import yatospace.jsp.user.io.SessionStorage;
import yatospace.jsp.user.io.UserStorage;

/**
 * Logon control center. 
 * @author MV
 * @version 1.0
 */
public interface LogonControlCenter {
	public RegisterController getRegisterController(); 
	public LogonController    getLogonController(); 
	public SessionStorage     getSessionStorage();
	public UserStorage        getUserStorage();
}
