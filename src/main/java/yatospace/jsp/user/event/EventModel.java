package yatospace.jsp.user.event;

/**
 * Ordered events map, events model. 
 * @author MV
 * @version 1.0
 */
public interface EventModel {
	public ParameterRunnable runnable(); 
	public void setRunnable(ParameterRunnable runnable);
}
