package yatospace.jsp.user.event;

/**
 * Event descriptor. 
 * @author MV
 * @version 1.0
 */
public interface EventDescriptor {
	public String id();
	public int order(); 
	public void setId(String id);
	public void setOrder(int order); 
}
