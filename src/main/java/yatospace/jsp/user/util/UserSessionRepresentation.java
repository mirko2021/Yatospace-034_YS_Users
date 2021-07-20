package yatospace.jsp.user.util;

/**
 * Session representation with user data accepting. 
 * @author MV
 * @version 1.0
 */
public interface UserSessionRepresentation extends SessionRepresentation{
	public boolean hasUser(); 
	public String user(); 
}
