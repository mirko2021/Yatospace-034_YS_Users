package yatospace.jsp.user.enviroment;

import java.util.List;

import yatospace.jsp.user.util.SessionRepresentation;

/**
 * Филтрирање HTTP сесија од осталих. 
 * @author MV
 * @version 1.0
 */
public interface HttpSessionManaging {
	public List<SessionRepresentation> listHttp();
	public List<SessionRepresentation> listHttp(int pageNo, int pageSize); 
}
