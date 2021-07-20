package yatospace.jsp.user.web.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import yatospace.jsp.user.application.BasicLogonControlCenter;
import yatospace.jsp.user.application.BasicRegisterControlCenter;
import yatospace.jsp.user.application.GeneralApplicationPoint;
import yatospace.jsp.user.application.LogonControlCenter;
import yatospace.jsp.user.application.RegisterControlCenter;
import yatospace.jsp.user.controller.BasicLogonController;
import yatospace.jsp.user.controller.BasicRegistrationController;
import yatospace.jsp.user.controller.LogonController;
import yatospace.jsp.user.controller.RegisterController;
import yatospace.jsp.user.engine.AuthenticationEngine;
import yatospace.jsp.user.engine.NonAuthenticationEngine;
import yatospace.jsp.user.enviroment.BasicHttpUserSessionManaging;
import yatospace.jsp.user.enviroment.HttpUserSessionsManaging;
import yatospace.jsp.user.io.SessionStorage;
import yatospace.jsp.user.io.UserStorage;

/**
 * Listener of session controllers and storages; 
 * @author MV
 * @version 1.0
 */
@WebListener
public class SessionContollersListener implements HttpSessionListener {
    public static final UserStorage    userStorage    = GeneralApplicationPoint.userStorageCenter.getStorage(); 
	public static final SessionStorage sessionStorage = GeneralApplicationPoint.sessionStorageCenter.getStorage(); 
    
	private final static HashMap<HttpSession, RegisterControlCenter> registerControlCenters = new HashMap<>(); 
	private final static HashMap<HttpSession, LogonControlCenter>    logonControlCenters    = new HashMap<>(); 
	
	public static synchronized Map<HttpSession, RegisterControlCenter> registerControlCenters(){
		return new HashMap<HttpSession, RegisterControlCenter>(registerControlCenters); 
	}
	
	public static synchronized Map<HttpSession, LogonControlCenter> logonControlCenters(){
		return new HashMap<HttpSession, LogonControlCenter>(logonControlCenters); 
	}
	
	public static synchronized RegisterControlCenter getRegisterControlCenter(HttpSession session) {
		return registerControlCenters.get(session); 
	}
	
	public static synchronized LogonControlCenter getLogonControlCenter(HttpSession session) {
		return logonControlCenters().get(session); 
	}
	
    public SessionContollersListener() {}

    public void sessionCreated(HttpSessionEvent se)  { 
		RegisterController registerController = new BasicRegistrationController(); 
		LogonController logonController = new BasicLogonController(); 
		AuthenticationEngine authEngine = new NonAuthenticationEngine();
		HttpUserSessionsManaging userSessionEnviroment = new BasicHttpUserSessionManaging(sessionStorage); 
		RegisterControlCenter registerCenter = new BasicRegisterControlCenter(registerController, userStorage, authEngine); 
		LogonControlCenter logonCenter = new BasicLogonControlCenter(registerController, logonController, sessionStorage, userStorage, authEngine ,userSessionEnviroment);
    	synchronized(SessionContollersListener.class) {
    		registerControlCenters.put(se.getSession(), registerCenter);
    		logonControlCenters.put(se.getSession(), logonCenter);
    	}
    }

    public void sessionDestroyed(HttpSessionEvent se)  { 
    	synchronized(SessionContollersListener.class) {
    		registerControlCenters.remove(se.getSession()); 
    		logonControlCenters.remove(se.getSession()); 
    	}
    }	
}
