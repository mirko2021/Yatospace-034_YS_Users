package yatospace.jsp.user.event;

/**
 * Eevent.
 * @author MV
 * @version 1.0
 */
public interface Event extends Comparable<Event>{
	public EventDescriptor descriptor(); 
	public EventModel      model();
	
	@Override 
	public default int compareTo(Event event) {
		return descriptor().id().compareTo(event.descriptor().id()); 
	}
	
	public default void run(ParameterMap map) {
		model().runnable().run(map);
	}
}
