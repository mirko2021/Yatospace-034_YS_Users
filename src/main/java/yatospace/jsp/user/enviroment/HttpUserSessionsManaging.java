package yatospace.jsp.user.enviroment;

import java.util.List;

import yatospace.jsp.user.util.SessionRepresentation;

/**
 * Filtering of the http userful sessions.
 * @author MV
 * @version 1.0
 */
public interface HttpUserSessionsManaging extends UserSessionManaging, HttpSessionManaging{
	public List<SessionRepresentation> listUserHttp();
	public List<SessionRepresentation> listUserHttp(int pageNo, int pageSize); 
}
