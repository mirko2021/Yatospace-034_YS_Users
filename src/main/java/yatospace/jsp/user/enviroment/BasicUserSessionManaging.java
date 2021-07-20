package yatospace.jsp.user.enviroment;

import java.util.ArrayList;
import java.util.List;

import yatospace.jsp.user.io.SessionStorage;
import yatospace.jsp.user.util.SessionRepresentation;
import yatospace.jsp.user.util.UserSessionRepresentation;

/**
 * Implementation of filtering enviroment of sessions with user data. 
 * @author MV
 * @version 1.0
 */
public class BasicUserSessionManaging implements UserSessionManaging{
	private SessionStorage storage;
	
	public BasicUserSessionManaging(SessionStorage storage) {
		if(storage==null) throw new NullPointerException();
		this.storage = storage; 
	}

	@Override
	public List<SessionRepresentation> listUser() {
		ArrayList<SessionRepresentation> target = new ArrayList<>();
		for(SessionRepresentation rep: storage.list()) 
			if(rep instanceof UserSessionRepresentation) storage.add(rep);
		return target;
	}

	@Override
	public List<SessionRepresentation> listUser(int pageNo, int pageSize) {
		ArrayList<SessionRepresentation> target = new ArrayList<>();
		ArrayList<SessionRepresentation> result = new ArrayList<>();
		for(SessionRepresentation rep: storage.list()) 
			if(rep instanceof UserSessionRepresentation) storage.add(rep);
		if(pageNo<=0) return result; pageNo--;
		if(pageSize<1) pageSize = 1; 
		int a = Math.min(target.size(), pageSize*pageNo); 
		int b = Math.min(target.size(), pageSize*pageNo+pageSize); 
		for(int i=a; i<b; i++)
			result.add(target.get(i)); 
		return target;
	}

	public SessionStorage getStorage() {
		return storage;
	}
}
