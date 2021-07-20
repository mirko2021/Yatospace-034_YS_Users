package yatospace.jsp.user.application;

import yatospace.jsp.user.io.BasicUserStorage;

/**
 * Basic implementation of user storage center; 
 * @author MV
 * @version 1.0
 */
public class BasicUserStorageCenter implements UserStorageCenter{
	private BasicUserStorage storage = new BasicUserStorage();
	
	@Override
	public BasicUserStorage getStorage() {
		return storage;
	}	
}
