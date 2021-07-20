package yatospace.jsp.user.object;

import java.io.Serializable;

/**
 * Корисници. 
 * @author MV
 * @version 1.0 
 */
public class User implements Serializable, Cloneable, Comparable<User>{
	private static final long serialVersionUID = -4056330333707264782L;
	private String username = ""; 
	private String password = "";
	private String firstname = ""; 
	private String secondname = ""; 
	private String usernotes = "";
	
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
		if(password == null) password = "";
		this.password = password;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		if(secondname == null) secondname = ""; 
		this.secondname = secondname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		if(firstname==null) firstname = ""; 
		this.firstname = firstname;
	}

	public String getUsernotes() {
		return usernotes;
	}



	public void setUsernotes(String usernotes) {
		if(usernotes == null) usernotes = ""; 
		this.usernotes = usernotes;
	}
	
	@Override 
	public int hashCode() {
		return username.hashCode(); 
	}
	
	@Override
	public String toString() {
		return username; 
	}
	
	@Override 
	public boolean equals(Object object) {
		if(object instanceof  User) {
			User user = (User) object; 
			return username.contentEquals(user.username); 
		}
		return false;
	}
	
	@Override
	public int compareTo(User o) {
		return username.compareTo(o.username);
	} 	
}
