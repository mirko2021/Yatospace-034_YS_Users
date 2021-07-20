package yatospace.jsp.user.application;

/**
 * General application point. Static storages and controllers, application level. 
 * @author MV
 * @version 1.0
 */
public final class GeneralApplicationPoint {
	private GeneralApplicationPoint() {}
	
	public static final BasicUserStorageCenter userStorageCenter = new BasicUserStorageCenter();
	public static final BasicSessionStorageCenter sessionStorageCenter = new BasicSessionStorageCenter(); 
}
