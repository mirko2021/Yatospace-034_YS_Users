package yatospace.jsp.user.util;

/**
 * General specification session descriptor. 
 * @author MV
 * @version 1.0
 */
public interface SessionDescriptor {
	public String generalId(); 
	public String localId(); 
	public String localSessionNotes();
	public String generalSessionNotes(); 
}
