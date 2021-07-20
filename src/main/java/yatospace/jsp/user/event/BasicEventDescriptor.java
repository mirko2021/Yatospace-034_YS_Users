package yatospace.jsp.user.event;

/**
 * Event descriptor. 
 * @author MV
 * @version 1.0
 */
public class BasicEventDescriptor implements EventDescriptor{
	private String id = "";
	private int order = 0; 
	
	@Override
	public String id() {
		return id;
	}

	@Override
	public int order() {
		return order;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		if(id==null) id = ""; 
		this.id = id;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
	
}
