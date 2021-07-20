package yatospace.jsp.user.event;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation basic event map. 
 * @author MV
 * @version 1.0
 */
public class BasicEventMap implements EventMap{
	private HashMap<String, Event> eventMap = new HashMap<>(); 
	private int minimalOrder = 0; 
	private int maximalOrder = 0; 
	
	@Override
	public synchronized List<String> ids() {
		ArrayList<String> list = new ArrayList<>(eventMap.keySet()); 
		Collections.sort(list);
		return list;
	}

	@Override
	public synchronized Map<String, Integer> order() {
		HashMap<String, Integer> result = new HashMap<>(); 
		for(String id: ids()) result.put(id, eventMap.get(id).descriptor().order());
		return result;
	}

	@Override
	public synchronized ParameterRunnable getById(String id) {
		try {
			return eventMap.get(id).model().runnable();
		}catch(Exception ex) {
			return null; 
		}
	}

	@Override
	public synchronized ParameterRunnable getByOrder(int order) {
		try {
			Map<String, Integer> orderMap = order();
			for(Map.Entry<String, Integer> me: orderMap.entrySet())
				if(me.getValue()==order) return getById(me.getKey());
			return null;
		}catch(Exception ex) {
			return null; 
		}
	}

	@Override
	public synchronized void addLast(ParameterRunnable runnable, String id) {
		if(getById(id)!=null) return; 
		if(runnable==null) return; 
		if(id==null) return; 
		if(id.trim().length()==0) return; 
		maximalOrder++; 
		BasicEventDescriptor description = new BasicEventDescriptor(); 
		BasicEventModel model = new BasicEventModel (); 
		description.setId(id);
		description.setOrder(maximalOrder);
		model.setRunnable(runnable);
		BasicEvent event = new BasicEvent(description, model); 
		eventMap.put(id, event); 
	}

	@Override
	public synchronized void addFirst(ParameterRunnable runable, String id) {
		if(getById(id)!=null) return; 
		if(runable==null) return; 
		if(id==null) return; 
		if(id.trim().length()==0) return; 
		minimalOrder--; 
		BasicEventDescriptor description = new BasicEventDescriptor(); 
		BasicEventModel model = new BasicEventModel (); 
		description.setId(id);
		description.setOrder(minimalOrder);
		model.setRunnable(runable);
		BasicEvent event = new BasicEvent(description, model); 
		eventMap.put(id, event); 
	}

	@Override
	public int minimalOrder() {
		return minimalOrder;
	}

	@Override
	public int maximalOrder() {
		return maximalOrder;
	}

	@Override
	public synchronized String idByOrder(int order) {
		try {
			Map<String, Integer> orderMap = order();
			for(Map.Entry<String, Integer> me: orderMap.entrySet())
				if(me.getValue()==order) return me.getKey();
			return null;
		}catch(Exception ex) {
			return null; 
		}
	}

	@Override
	public int orderById(String id) {
		try {
			return eventMap.get(id).descriptor().order();
		}catch(RuntimeException ex) {
			throw ex; 
		}catch(Exception ex) {
			throw new RuntimeException(ex); 
		}
	}

	@Override
	public synchronized void put(String id, ParameterRunnable runnable) {
		if(id==null) return; 
		if(id.trim().length()==0) return; 
		if(runnable==null) return; 
		if(eventMap.get(id)==null) return; 
		eventMap.get(id).model().setRunnable(runnable);
	}

	@Override
	public synchronized void put(int order, ParameterRunnable runnable) {
		if(runnable==null) return; 
		String id = this.idByOrder(order); 
		if(id==null) return; 
		put(id, runnable); 
		refreshMinimax();
	}

	@Override
	public synchronized void reorder(String id, int neworder) {
		if(id==null) return; 
		if(id.trim().length()==0) return; 
		try {
			String identificator = idByOrder(neworder); 
			if(identificator!=null) return; 
			eventMap.get(identificator).descriptor().setOrder(neworder);
			refreshMinimax();
		}catch(Exception ex) {
			return; 
		}
	}

	@Override
	public synchronized void rename(String oldId, String newId) {
		if(oldId==null) return; 
		if(newId==null) return; 
		if(oldId.trim().length()==0) return; 
		if(newId.trim().length()==0) return; 
		Event eo = eventMap.get(oldId); 
		Event en = eventMap.get(newId); 
		if(eo==null) return; 
		if(en!=null) return; 
		eventMap.remove(oldId); 
		eo.descriptor().setId(newId);
		eventMap.put(newId, eo);
	}

	@Override
	public synchronized void remove(String id) {
		eventMap.remove(id); 
		refreshMinimax();
	}

	@Override
	public synchronized void remove(int order) {
		try {
			String id = idByOrder(order);
			remove(id);
			refreshMinimax();
		}catch(Exception ex) {
			return; 
		}
	}

	@Override
	public void shiftputUp(String id, int order, ParameterRunnable runnable) {
		try {
			if(id==null) return; 
			if(id.length()==0) return; 
			if(runnable==null) return;
			String oId = idByOrder(order);
			if(get(id)!=null && get(oId)!=null && get(id)!=get(oId)) {
				shiftUp(id, order, runnable);
				return; 
			}
			put(id, order, runnable);
		}catch(Exception ex) {
			return; 
		}
	}

	@Override
	public void shiftputDown(String id, int order, ParameterRunnable runnable) {
		try {
			if(id==null) return; 
			if(id.length()==0) return; 
			if(runnable==null) return;
			String oId = idByOrder(order);
			if(get(id)!=null && get(oId)!=null && get(id)!=get(oId)) {
				shiftDown(id, order, runnable);
				return; 
			}
			put(id, order, runnable);
		}catch(Exception ex) {
			return; 
		}
	}

	@Override
	public void shiftUp(String id, int order, ParameterRunnable runnable) {
		shiftUp(order);
		put(id, order, runnable);
		refreshMinimax();
	}

	@Override
	public void shiftDown(String id, int order, ParameterRunnable runnable) {
		shiftDown(order);
		put(id, order, runnable);
		refreshMinimax();
	}

	@Override
	public synchronized void shiftDown(int order) {
		List<Event> events = list();
		for(Event e: events) {
			if(e.descriptor().order()>=order) 
				e.descriptor().setOrder(e.descriptor().order()+1);
		}
		refreshMinimax();
	}

	@Override
	public synchronized void shiftUp(int order) {
		List<Event> events = list();
		for(Event e: events) {
			if(e.descriptor().order()<=order) 
				e.descriptor().setOrder(e.descriptor().order()-1);
		}
		refreshMinimax();
	}

	@Override
	public void shiftDown(int order, int step) {
		if(step<1) step = 1;
		List<Event> events = list();
		for(Event e: events) {
			if(e.descriptor().order()>=order) 
				e.descriptor().setOrder(e.descriptor().order()+step);
		}
		refreshMinimax();
	}

	@Override
	public void shiftUp(int order, int step) {
		if(step<1) step=1;
		List<Event> events = list();
		for(Event e: events) {
			if(e.descriptor().order()<=order) 
				e.descriptor().setOrder(e.descriptor().order()-step);
		}
		refreshMinimax();
	}

	@Override
	public void run(ParameterMap params) {
		List<Event> events = list();
		synchronized(events) { 
			for(int i=0; i<events.size()-1; i++) {
				for(int j=i+1; j<events.size(); j++) {
					Event a = events.get(i);
					Event b = events.get(j);
					if(a.descriptor().order()>b.descriptor().order()) {
						events.set(j, a); 
						events.set(i, b);
					}
				}
			}
		}
		for(Event e: events) e.run(params);
	}

	@Override
	public synchronized Event get(String id) {
		return eventMap.get(id);
	}

	@Override
	public synchronized List<Event> list() {
		ArrayList<String> events = new ArrayList<>(eventMap.keySet());
		Collections.sort(events);
		ArrayList<Event> target = new ArrayList<Event>(); 
		for(String event: events)
			target.add(eventMap.get(event)); 
		return target;
	}

	@Override
	public synchronized List<Event> list(int pageNo, int pageSize) {
		ArrayList<String> events = new ArrayList<>(eventMap.keySet()); 
		Collections.sort(events);
		ArrayList<Event> target = new ArrayList<Event>(); 
		ArrayList<Event> result = new ArrayList<Event>(); 
		for(String event: events)
			target.add(eventMap.get(event)); 
		if(pageNo<=0) return result; pageNo--; 
		if(pageSize<1) pageSize = 1; 
		int a = Math.min(target.size(), pageSize*pageNo); 
		int b = Math.min(target.size(), pageSize*pageNo+pageSize);
		for(int i=a; i<b; i++)
			result.add(target.get(i)); 
		return result;
	}

	@Override
	public synchronized void put(String id, int order, ParameterRunnable runnable) {	
		try {
			if(id==null) return; 
			if(runnable==null) return; 
			if(id.trim().length()!=0) return; 
			String oId = idByOrder(order); 
			if(get(oId)!=null && get(id)!=null && get(oId)!=get(id)) return;  
			if(get(oId)!=null && get(id)!=null) {
				Event e = get(oId); 
				e.model().setRunnable(runnable);
				e.descriptor().setId(id);
				e.descriptor().setOrder(order);
				this.refreshMinimax();
				return; 
			}
			if(get(oId)!=null){
				Event e = get(oId); 
				e.model().setRunnable(runnable);
				e.descriptor().setId(id);
				e.descriptor().setOrder(order);
				eventMap.remove(oId); 
				eventMap.put(id, e); 
				if(order>maximalOrder) maximalOrder = order;
				if(order<minimalOrder) minimalOrder = order;
				return; 
			}
			if(get(id)!=null){
				Event e = get(oId); 
				e.model().setRunnable(runnable);
				e.descriptor().setId(id);
				e.descriptor().setOrder(order);
				if(order>maximalOrder) maximalOrder = order;
				if(order<minimalOrder) minimalOrder = order;
				return; 
			}
			BasicEventDescriptor description = new BasicEventDescriptor(); 
			BasicEventModel model = new BasicEventModel (); 
			description.setId(id);
			description.setOrder(maximalOrder);
			model.setRunnable(runnable);
			BasicEvent event = new BasicEvent(description, model); 
			eventMap.put(id, event); 
			if(order>maximalOrder) maximalOrder = order;
			if(order<minimalOrder) minimalOrder = order;
		}catch(Exception ex) {
			return; 
		}
	}
	
	@Override
	public synchronized void refreshMinimax() {
		minimalOrder = 0; 
		maximalOrder = 0; 
		List<Event> events = list(); 
		if(events.size()==0) return; 
		minimalOrder = events.get(0).descriptor().order(); 
		maximalOrder = events.get(0).descriptor().order(); 
		for(Event e: events) {
			minimalOrder = Math.min(minimalOrder, e.descriptor().order()); 
			maximalOrder = Math.max(minimalOrder, e.descriptor().order()); 
		}
	}
	
	public synchronized int realMaximalOrder() {
		int maximalOrder = 0; 
		List<Event> events = list(); 
		if(events.size()==0) return 0; 
		maximalOrder = events.get(0).descriptor().order(); 
		for(Event e: events) {
			maximalOrder = Math.max(maximalOrder, e.descriptor().order()); 
		}
		return maximalOrder;
	}
	
	public synchronized int realMinimalOrder() {
		int minimalOrder = 0; 
		List<Event> events = list(); 
		if(events.size()==0) return 0; 
		minimalOrder = events.get(0).descriptor().order();  
		for(Event e: events) {
			minimalOrder = Math.min(minimalOrder, e.descriptor().order()); 
		}
		return minimalOrder; 
	}
}
