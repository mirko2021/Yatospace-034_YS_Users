package yatospace.jsp.user.web.bean;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import yatospace.jsp.user.controller.RegisterController;
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
	
	
	public void update(HttpSession session, PageExecutingBean pageExcutingBean) {
		try {
			UserStorage storage = SessionContollersListener.getRegisterControlCenter(session).getUserStorage();
			RegisterController controller = SessionContollersListener.getRegisterControlCenter(session).getRegisterController();
			if(pageExcutingBean.getStatus().liveMessages().size()==0) pageExcutingBean.getStatus().liveMessages().add(""); 
			User user = storage.get(username);
			if(user==null) throw new RuntimeException();
			user.setFirstname(name);
			user.setSecondname(surname);
			controller.upadte(username, user); 
			pageExcutingBean.getStatus().liveMessages().set(0, "Измјене корисника су успјешне.");
		}catch(Exception ex) {
			pageExcutingBean.getStatus().liveMessages().set(0, "Измјене корисника нису успјешне.");
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
}
