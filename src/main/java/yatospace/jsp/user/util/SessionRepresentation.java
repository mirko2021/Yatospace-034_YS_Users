package yatospace.jsp.user.util;

/**
 * Basic specification of representer for all sessions in system/s. 
 * @author MV
 * @version 1.0
 */
public interface SessionRepresentation extends Comparable<SessionRepresentation>{
	public SessionDescriptor getDescriptor();
	
	public default boolean isBasicHttpSessionRepresentation() {
		return this instanceof BasicHttpSessionRepresentation; 
	}
	
	public default boolean isUserHttpSessionRepresentation() {
		return this instanceof UserHttpSessionRepresentation; 
	}
	
	public default boolean isUserSessionRepresentation() {
		return this instanceof UserSessionRepresentation; 
	}
	
	public default BasicHttpSessionRepresentation asBasicHttpSessionRepresentation() {
		if(this instanceof BasicHttpSessionRepresentation) return (BasicHttpSessionRepresentation) this;
		return null;
	}
	
	public default UserHttpSessionRepresentation asUserHttpSessionRepresentation() {
		if(this instanceof UserHttpSessionRepresentation) return (UserHttpSessionRepresentation) this;
		return null;
	}
	
	public default UserSessionRepresentation asUserSessionRepresentation() {
		if(this instanceof  UserSessionRepresentation) return (UserSessionRepresentation) this; 
		return null;
	}
	
	@Override
	public default int compareTo(SessionRepresentation rep) {
		return getDescriptor().generalId().compareTo(rep.getDescriptor().generalId()); 
	}
}
