package yatospace.jsp.user.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import yatospace.jsp.user.util.SessionRepresentation;

/**
 * Basic implementation of Session Storage. 
 * @author MV
 * @version 1.0
 */
public class BasicSessionStorage implements SessionStorage {
	private HashMap<String, SessionRepresentation> sessions = new HashMap<String, SessionRepresentation>(); 
	

	@Override
	public synchronized void remove(String id) {
		sessions.remove(id); 
	}

	@Override
	public synchronized SessionRepresentation get(String id) {
		return sessions.get(id);
	}

	@Override
	public synchronized void add(SessionRepresentation representation) {
		if(representation==null) return;
		if(sessions.containsKey(representation.getDescriptor().generalId())) return; 
		sessions.put(representation.getDescriptor().generalId(), representation);
	}

	@Override
	public synchronized void put(SessionRepresentation representation) {
		if(representation==null) return;
		sessions.put(representation.getDescriptor().generalId(), representation);
	}

	@Override
	public synchronized List<SessionRepresentation> list() {
		ArrayList<SessionRepresentation> sessions = new ArrayList<>(this.sessions.values());
		Collections.sort(sessions);
		return sessions;
	}

	@Override
	public synchronized List<SessionRepresentation> list(int pageNo, int pageSize) {
		ArrayList<SessionRepresentation> sessions = new ArrayList<>(this.sessions.values());
		ArrayList<SessionRepresentation> result = new ArrayList<>(); 
		Collections.sort(sessions);
		if(pageNo<=0) return result; pageNo--; 
		if(pageSize<1) pageSize = 1;
		int a = Math.min(sessions.size(), pageSize*pageNo); 
		int b = Math.min(sessions.size(), pageSize*pageNo+pageSize); 
		for(int i=a; i<b; i++)
			result.add(sessions.get(i)); 
		return result;
	}
}
