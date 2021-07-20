package yatospace.jsp.user.application;

import javax.servlet.http.HttpSession;

import yatospace.jsp.user.controller.BasicLogonController;
import yatospace.jsp.user.controller.LogonController;
import yatospace.jsp.user.controller.RegisterController;
import yatospace.jsp.user.engine.AuthenticationEngine;
import yatospace.jsp.user.enviroment.HttpUserSessionsManaging;
import yatospace.jsp.user.event.ParameterObject;
import yatospace.jsp.user.event.ParameterType;
import yatospace.jsp.user.io.SessionStorage;
import yatospace.jsp.user.io.UserStorage;
import yatospace.jsp.user.object.User;
import yatospace.jsp.user.util.UserHttpSessionRepresentation;

/**
 * Basic implementation of the logon control center. 
 * @author MV
 * @version 1.0
 */
public class BasicLogonControlCenter implements LogonControlCenter{
	private RegisterController registerController; 
	private LogonController logonController; 
	private SessionStorage sessionStorage; 
	private UserStorage userStorage; 
	private AuthenticationEngine authEngine;
	private HttpUserSessionsManaging userSessionEnviroment; 
	
	public BasicLogonControlCenter(
			RegisterController registerController, 
			LogonController logonController, 
			SessionStorage sessionStorage, 
			UserStorage userStorage, 
			AuthenticationEngine authEngine, 
			HttpUserSessionsManaging userSessionEnviroment) {
		if(userSessionEnviroment==null) throw new NullPointerException(); 
		if(registerController==null) throw new NullPointerException();
		if(logonController==null) throw new NullPointerException();
		if(sessionStorage==null) throw new NullPointerException();
		if(userStorage==null) throw new NullPointerException();
		if(authEngine==null) throw new NullPointerException(); 
		this.userSessionEnviroment = userSessionEnviroment;
		this.registerController = registerController; 
		this.logonController = logonController; 
		this.sessionStorage = sessionStorage; 
		this.userStorage = userStorage; 
		this.authEngine = authEngine; 
		if(logonController instanceof BasicLogonController) {
			BasicLogonController realController = (BasicLogonController) logonController; 
			realController.onlogin().addLast(params->{
				HttpSession session = (HttpSession) params.get("session").getParameterValue();
				String username = (String) params.get("username").getParameterValue(); 
				String password = (String) params.get("password").getParameterValue();
				if(session.getAttribute(username)!=null) {
					ParameterObject successParam = new ParameterObject("success");
					successParam.setOutputProvider(this);
					successParam.setParameterType(ParameterType.OUT); 
					successParam.setParameterClazz(Boolean.class); 
					successParam.setParameterValue(false);
					return; 
				} 
				if(userStorage.get(username)==null) {
					ParameterObject successParam = new ParameterObject("success");
					successParam.setOutputProvider(this);
					successParam.setParameterType(ParameterType.OUT); 
					successParam.setParameterClazz(Boolean.class); 
					successParam.setParameterValue(false);
					return; 
				};
				User user = userStorage.get(username);
				boolean checkPasswordResult = false; 
				synchronized(authEngine) {
					authEngine.setPasswordRecord(user.getPassword());
					checkPasswordResult = authEngine.checkPassword(password); 
				}
				if(!checkPasswordResult) {
					ParameterObject successParam = new ParameterObject("success");
					successParam.setOutputProvider(this);
					successParam.setParameterType(ParameterType.OUT); 
					successParam.setParameterClazz(Boolean.class); 
					successParam.setParameterValue(false);
					return; 
				};
				UserHttpSessionRepresentation userHttpSession = new UserHttpSessionRepresentation(session);
				sessionStorage.put(userHttpSession);
				session.setAttribute("username", username);
				ParameterObject successParam = new ParameterObject("success");
				successParam.setOutputProvider(this);
				successParam.setParameterType(ParameterType.OUT); 
				successParam.setParameterClazz(Boolean.class); 
				successParam.setParameterValue(true);
			}, "login");
			
			realController.onlogout().addLast(params->{
				HttpSession session = (HttpSession) params.get("session").getParameterValue();
				String username = (String) session.getAttribute("username");
				if(username==null) return; 
				sessionStorage.remove(session.getId());
				session.removeAttribute("username"); 
			}, "logout");
			realController.onlogoutAll().addLast(params->{
				String username = (String) params.get("username").getParameterValue(); 
				for(var sessionRep: userSessionEnviroment.listUserHttp()) {
					if(sessionRep.asUserHttpSessionRepresentation()==null) continue; 
					HttpSession session = sessionRep.asUserHttpSessionRepresentation().asUserHttpSessionRepresentation().getSession(); 
					if(session==null) continue; 
					if(session.getAttribute("username")==null) continue;
					if(!session.getAttribute("username").toString().contentEquals(username)) continue; 
					session.removeAttribute("username"); 
					sessionStorage.remove(session.getId());
				} 
			}, "logoutall");
		}
	}
	
	@Override
	public RegisterController getRegisterController() {
		return registerController;
	}

	@Override
	public LogonController getLogonController() {
		return logonController;
	}

	@Override
	public SessionStorage getSessionStorage() {
		return sessionStorage;
	}

	@Override
	public UserStorage getUserStorage() {
		return userStorage;
	}

	public AuthenticationEngine getAuthEngine() {
		return authEngine;
	}

	public HttpUserSessionsManaging getUserSessionEnviroment() {
		return userSessionEnviroment;
	}
}
