package yatospace.jsp.user.application;

import yatospace.jsp.user.io.BasicSessionStorage;

/**
 * Basic implementation of the session storage. 
 * @author MV
 * @version 1.0
 */
public class BasicSessionStorageCenter implements SessionStorageCenter{
	private BasicSessionStorage storage  = new BasicSessionStorage();
	
	@Override
	public BasicSessionStorage getStorage() {
		return storage;
	}
	
}
