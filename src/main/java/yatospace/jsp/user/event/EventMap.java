package yatospace.jsp.user.event;

import java.util.List;
import java.util.Map;

/**
 * Event Container. 
 * @author MV
 * @version 1.0
 */
public interface EventMap{
	public List<String> ids();
	public Map<String, Integer> order();
	public ParameterRunnable getById(String id);
	public ParameterRunnable getByOrder(int order);
	public void addLast(ParameterRunnable runnable, String id);
	public void addFirst(ParameterRunnable runnable, String id); 
	public int minimalOrder(); 
	public int maximalOrder(); 
	public String idByOrder(int order);
	public int orderById(String id); 
	public void put(String id, ParameterRunnable runnable);
	public void put(int order, ParameterRunnable runnable); 
	public void put(String id, int order, ParameterRunnable runnable);
	public void reorder(String id, int neworder);
	public void rename(String oldId, String newId); 
	public void remove(String id); 
	public void remove(int order); 
	public void shiftputUp(String id, int order, ParameterRunnable runnable); 
	public void shiftputDown(String id, int order, ParameterRunnable runnable);
	public void shiftUp(String id, int order, ParameterRunnable runnable); 
	public void shiftDown(String id, int order, ParameterRunnable runnable);
	public void shiftDown(int order);
	public void shiftUp(int order);
	public void shiftDown(int order, int step);
	public void shiftUp(int order, int step);
	public Event get(String id); 
	public List<Event> list(); 
	public List<Event> list(int pageNo, int pageZone); 
	public void refreshMinimax();
	public void run(ParameterMap params); 
}
