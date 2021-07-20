package yatospace.jsp.user.engine;

/**
 * Password testing, and store; 
 * @author MV
 * @version 1.0
 */
public interface AuthenticationEngine {
	public String passwordRecord(); 
	public void storePassword(String password);
	public boolean checkPassword(String password); 
	public void setPasswordRecord(String record); 
}
