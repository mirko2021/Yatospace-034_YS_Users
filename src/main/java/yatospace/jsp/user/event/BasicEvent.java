package yatospace.jsp.user.event;

/**
 * Basic event implementation. 
 * @author MV
 * @version 1.0
 */
public class BasicEvent implements Event{
	private BasicEventDescriptor descriptor; 
	private BasicEventModel model; 
	
	public BasicEvent(BasicEventDescriptor descriptor, BasicEventModel model) {
		if(descriptor==null) throw new NullPointerException(); 
		if(model==null) throw new NullPointerException(); 
		this.descriptor  = descriptor; 
		this.model = model; 
	}
	
	@Override
	public EventDescriptor descriptor() {
		return descriptor;
	}

	@Override
	public EventModel model() {
		return model;
	}

	public BasicEventModel getModel() {
		return model;
	}

	public BasicEventDescriptor getDescriptor() {
		return descriptor;
	}
}
