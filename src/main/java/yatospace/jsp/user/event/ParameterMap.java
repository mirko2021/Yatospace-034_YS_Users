package yatospace.jsp.user.event;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Parameters map. 
 * @author MV
 * @version 1.0
 */
public class ParameterMap implements Serializable{
	private static final long serialVersionUID = -7458196458975201818L;
	
	private HashMap<String, ParameterObject> parameterMap = new HashMap<>(); 
	
	public synchronized List<String> parameters(){
		return new ArrayList<>(parameterMap.keySet()); 
	}
	
	public synchronized ParameterObject get(String name) {
		return parameterMap.get(name); 
	}
	
	public synchronized void add(ParameterObject object) {
		if(object==null) return; 
		if(parameterMap.containsKey(object.getParameterName())) return; 
		parameterMap.put(object.getParameterName(), object); 
	}
	
	public synchronized void put(ParameterObject object) {
		if(object==null) return; 
		parameterMap.put(object.getParameterName(), object);
	}
	
	public synchronized void remove(String name) {
		parameterMap.remove(name); 
	}
}
