package yatospace.jsp.user.application;

import yatospace.jsp.user.io.SessionStorage;

/**
 * Specification of the storage center for sessions. 
 * @author MV
 * @version 1.0
 */
public interface SessionStorageCenter {
	public SessionStorage getStorage();
}
