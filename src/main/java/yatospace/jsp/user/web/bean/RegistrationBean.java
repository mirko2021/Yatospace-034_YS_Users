package yatospace.jsp.user.web.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import yatospace.jsp.user.application.BasicRegisterControlCenter;
import yatospace.jsp.user.controller.RegisterController;
import yatospace.jsp.user.engine.AuthenticationEngine;
import yatospace.jsp.user.io.UserStorage;
import yatospace.jsp.user.object.User;
import yatospace.jsp.user.web.listener.SessionContollersListener;

/**
 * Bean for user register. 
 * @author MV
 * @version 1.0
 */
public class RegistrationBean implements Serializable{
	private static final long serialVersionUID = 6167142721299534266L;
	private String username = ""; 
	private String password = ""; 
	private String surname = ""; 
	private String name = ""; 
	private String newUsername = ""; 
	private String oldUsername = ""; 
	
	public String getNewUsername() {
		return newUsername;
	}
	public void setNewUsername(String newUsername) {
		if(newUsername==null) newUsername = ""; 
		this.newUsername = newUsername;
	}
	
	public String getOldUsername() {
		return oldUsername;
	}
	public void setOldUsername(String oldUsername) {
		if(oldUsername==null) oldUsername = ""; 
		this.oldUsername = oldUsername;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(username==null) username = ""; 
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password==null) password = ""; 
		this.password = password;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void register(HttpSession session, PageExecutingBean pageExcutingBean) {
		RegisterController registerController = SessionContollersListener.getRegisterControlCenter(session).getRegisterController();
		UserStorage userStorage = SessionContollersListener.getRegisterControlCenter(session).getUserStorage(); 
		if(pageExcutingBean.getStatus().liveMessages().size()==0) pageExcutingBean.getStatus().liveMessages().add(""); 
		try {
			if(username.trim().length()==0) {
				pageExcutingBean.getStatus().liveMessages().set(0, "Регистровање није успјело.");
				return; 
			}
			if(userStorage.get(username)!=null) {
				pageExcutingBean.getStatus().liveMessages().set(0, "Регистровање није успјело.");
				return; 
			}
			User user = new User(); 
			user.setUsername(username);
			user.setFirstname(name);
			user.setSecondname(surname);
			user.setPassword(password);
			boolean success = (boolean) registerController.register(user).get("success").getParameterValue();
			password = ""; 
			if(success) {
				pageExcutingBean.getStatus().liveMessages().set(0, "Регистровање је успјело.");
			}else {
				pageExcutingBean.getStatus().liveMessages().set(0, "Регистровање није успјело.");
			}
		}catch(Exception ex) {
			pageExcutingBean.getStatus().liveMessages().set(0, "Регистровање није успјело.");
		}finally {
			password = ""; 
		}
	}
	
	
	public void deregister(HttpSession session, PageExecutingBean pageExcutingBean) {
		RegisterController registerController = SessionContollersListener.getRegisterControlCenter(session).getRegisterController();
		try {
			if(username.trim().length()==0) {
				pageExcutingBean.getStatus().liveMessages().set(0, "Брисање из регистра није успјело.");
				return; 
			}
			registerController.deregister(username);
			pageExcutingBean.getStatus().liveMessages().set(0, "Брисање из регистра је успјело.");
		}catch(Exception ex) {
			pageExcutingBean.getStatus().liveMessages().set(0, "Брисање из регистра није успјело.");
		}
	}
	
	public void deregister(HttpServletRequest request, PageExecutingBean pageExcutingBean) {
		RegisterController registerController = SessionContollersListener.getRegisterControlCenter(request.getSession()).getRegisterController();
		String username = request.getParameter("erase_form_input"); 
		if(pageExcutingBean.getStatus().liveMessages().size()==0) pageExcutingBean.getStatus().liveMessages().add(""); 
		try {
			if(username.trim().length()==0) {
				pageExcutingBean.getStatus().liveMessages().set(0, "Брисање из регистра није успјело.");
				return; 
			}
			registerController.deregister(username);
			pageExcutingBean.getStatus().liveMessages().set(0, "Брисање из регистра је успјело.");
		}catch(Exception ex) {
			pageExcutingBean.getStatus().liveMessages().set(0, "Брисање из регистра није успјело.");
		}
	}
	
	public void resetForRegister() {
		username = ""; 
		password = ""; 
		name = ""; 
		surname = ""; 
	}
	
	public void resetForUpdate() {
		username = ""; 
		password = ""; 
		name = ""; 
		surname = ""; 
	}
	
	public void resetForRename() {
		username = "";
		password = ""; 
		newUsername = ""; 
	}
	
	public void resetForRenewPassword() {
		username = "";
		password = ""; 
	}
	
	public void update(HttpSession session, PageExecutingBean pageExcutingBean) {
		try {
			UserStorage storage = SessionContollersListener.getRegisterControlCenter(session).getUserStorage();
			RegisterController controller = SessionContollersListener.getRegisterControlCenter(session).getRegisterController();
			if(pageExcutingBean.getStatus().liveMessages().size()==0) pageExcutingBean.getStatus().liveMessages().add(""); 
			User user = storage.get(username).clone();
			if(user==null) throw new RuntimeException();
			user.setFirstname(name);
			user.setSecondname(surname);
			controller.upadte(username, user); 
			pageExcutingBean.getStatus().liveMessages().set(0, "Измјене корисника су успјешне.");
		}catch(Exception ex) {
			pageExcutingBean.getStatus().liveMessages().set(0, "Измјене корисника нису успјешне.");
		}
	}
	
	public void rename(HttpSession session, PageExecutingBean pageExecutingBean) {
		try {
			if(pageExecutingBean.getStatus().liveMessages().size()==0) pageExecutingBean.getStatus().liveMessages().add(""); 
			UserStorage storage = SessionContollersListener.getRegisterControlCenter(session).getUserStorage();
			RegisterController controller = SessionContollersListener.getRegisterControlCenter(session).getRegisterController();
			User user = storage.get(username).clone();
			User neouser = storage.get(newUsername); 
			if(user==null) throw new NullPointerException(); 
			if(neouser!=null) throw new RuntimeException("Duplicate.");
			user.setUsername(newUsername);
			controller.upadte(username, user);
			username = newUsername; 
			newUsername = ""; 
			pageExecutingBean.getStatus().liveMessages().set(0, "Преименовање корисника је успјело.");
		}catch(Exception ex) {
			pageExecutingBean.getStatus().liveMessages().set(0, "Преименовање корисника није успјело.");
		}
	}
	
	public void changePassword(HttpSession session, PageExecutingBean pageExecutingBean) {
		try {
			UserStorage storage = SessionContollersListener.getRegisterControlCenter(session).getUserStorage();
			BasicRegisterControlCenter basicRegisterControlCenter = (BasicRegisterControlCenter) SessionContollersListener.getRegisterControlCenter(session);
			AuthenticationEngine authenticationEngine = basicRegisterControlCenter.getAuthenticationEngine(); 
			if(pageExecutingBean.getStatus().liveMessages().size()==0) pageExecutingBean.getStatus().liveMessages().add(""); 
			String record = ""; 
			synchronized(authenticationEngine) {authenticationEngine.storePassword(password); record = authenticationEngine.passwordRecord();}
			authenticationEngine.storePassword(password);
			User user = storage.get(username);
			if(user==null) throw new NullPointerException();
			user.setPassword(record);
			RegisterController controller = SessionContollersListener.getRegisterControlCenter(session).getRegisterController();
			controller.upadte(user.getUsername(), user);
			pageExecutingBean.getStatus().liveMessages().set(0, "Промјена лозинке је успјела.");
		}catch(Exception ex) {
			pageExecutingBean.getStatus().liveMessages().set(0, "Промјена лозинке није успјела.");
		}
	}
	
	public void acceptByUsername(HttpServletRequest request, PageExecutingBean pageExcutingBean) {
		try {
			UserStorage storage = SessionContollersListener.getRegisterControlCenter(request.getSession()).getUserStorage();
			User user = storage.get(request.getParameter("username"));
			if(pageExcutingBean.getStatus().liveMessages().size()==0) pageExcutingBean.getStatus().liveMessages().add(""); 
			if(user==null) resetForUpdate(); 
			if(user==null) throw new NullPointerException(); 
			password = "";
			username = user.getUsername();
			name = user.getFirstname();
			surname = user.getSecondname();
		}catch(Exception ex) {
			pageExcutingBean.getStatus().liveMessages().set(0, "Корисник са датим корисничким именом није нађен. Форма је ресетована.");
		}
	}
	
	public void testUsername(HttpServletRequest request, PageExecutingBean pageExcutingBean) {
		try {
			if(pageExcutingBean.getStatus().liveMessages().size()==0) pageExcutingBean.getStatus().liveMessages().add("");
			UserStorage storage = SessionContollersListener.getRegisterControlCenter(request.getSession()).getUserStorage();
			User user = storage.get(request.getParameter("username"));
			if(user==null) throw new RuntimeException();  
			pageExcutingBean.getStatus().liveMessages().set(0, "Корисничко име је нађено.");
		}catch(Exception ex) {
			pageExcutingBean.getStatus().liveMessages().set(0, "Корисничко име није нађено.");
		}
	}
	
	public void testPassword(HttpServletRequest request, PageExecutingBean pageExcutingBean) {
		try {
			if(pageExcutingBean.getStatus().liveMessages().size()==0) pageExcutingBean.getStatus().liveMessages().add("");
			RegisterController controller = SessionContollersListener.getRegisterControlCenter(request.getSession()).getRegisterController(); 
			boolean result = (boolean) controller.check(request.getParameter("username"), request.getParameter("password")).get("result").getParameterValue();  
			if(!result) throw new RuntimeException();
			pageExcutingBean.getStatus().liveMessages().set(0, "Комбинација лозинке и корисничког имена задовољава.");
			username = request.getParameter("username"); 
		}catch(Exception ex) {
			pageExcutingBean.getStatus().liveMessages().set(0, "Комбинација лозинке и корисничког имена не задовољава.");
			username = ""; 
		}finally {
			password = ""; 
		}
	}
}
