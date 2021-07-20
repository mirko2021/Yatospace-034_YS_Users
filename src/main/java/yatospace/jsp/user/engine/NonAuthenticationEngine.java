package yatospace.jsp.user.engine;

/**
 * Non-password pro-form short-circued authentication routines engine. 
 * @author MV
 * @version 1.0
 */
public class NonAuthenticationEngine implements AuthenticationEngine{
	private String passwordRecord = ""; 
	
	@Override
	public String passwordRecord() {
		return passwordRecord;
	}

	@Override
	public void storePassword(String password) {
		if(password == null) password = ""; 
		this.passwordRecord = password; 
	}

	@Override
	public boolean checkPassword(String password) {
		if(password == null) password = null; 
		return passwordRecord.contentEquals(password); 
	}
    
	@Override
	public void setPasswordRecord(String passwordRecord) {
		if(passwordRecord==null) return; 
		this.passwordRecord = passwordRecord;
	}
}
