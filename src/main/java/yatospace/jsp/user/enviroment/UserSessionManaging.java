package yatospace.jsp.user.enviroment;

import java.util.List;

import yatospace.jsp.user.util.SessionRepresentation;

/**
 * Филтрирање корисничких HTTP сесија од осталих. 
 * @author MV
 * @version 1.0
 */
public interface UserSessionManaging{
	public List<SessionRepresentation> listUser();
	public List<SessionRepresentation> listUser(int pageNo, int pageSize); 
}
