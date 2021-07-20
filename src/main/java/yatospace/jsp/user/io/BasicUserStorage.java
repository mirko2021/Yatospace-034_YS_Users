package yatospace.jsp.user.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import yatospace.jsp.user.object.User;

/**
 * Sample/simple user storage in JVM program memory. 
 * @author MV
 * @version 1.0
 */
public class BasicUserStorage implements UserStorage{
	private HashMap<String, User> userMap = new HashMap<String, User>(); 
	
	@Override
	public synchronized void add(User user) {
		if(user==null) return; 
		if(userMap.containsKey(user.getUsername())) return; 
		userMap.put(user.getUsername(), user); 
	}

	@Override
	public synchronized void put(User user) {
		if(user==null) return; 
		if(userMap.containsKey(user.getUsername())) return; 
		userMap.put(user.getUsername(), user); 
	}

	@Override
	public synchronized User get(String username) {
		return userMap.get(username);
	}

	@Override
	public synchronized void remove(String username) {
		userMap.remove(username); 
	}

	@Override
	public synchronized List<User> list() {
		ArrayList<User> users = new ArrayList<>(userMap.values());
		Collections.sort(users);
		return users;
	}

	@Override
	public List<User> list(int pageNo, int pageSize) {
		ArrayList<User> users = new ArrayList<>(userMap.values());
		ArrayList<User> result = new ArrayList<>(); 
		if(pageNo<=0) return result; pageNo--; 
		if(pageSize<1) pageSize = 1;
		Collections.sort(users);
		int a = Math.min(users.size(), pageSize*pageNo); 
		int b = Math.min(users.size(), pageSize*pageNo+pageSize); 
		for(int i=a; i<b; i++)
			result.add(users.get(i)); 
		return result;
	}
}
