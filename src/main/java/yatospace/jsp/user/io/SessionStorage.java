package yatospace.jsp.user.io;

import java.util.List;

import yatospace.jsp.user.util.SessionRepresentation;

/**
 * Session storage specification. 
 * @author MV
 * @vesion 1.0
 */
public interface SessionStorage {
	public void remove(String id); 
	public SessionRepresentation get(String id);
	public void add(SessionRepresentation representation); 
	public void put(SessionRepresentation representation);
	public List<SessionRepresentation> list(); 
	public List<SessionRepresentation> list(int pageNo, int pageSize);
}
