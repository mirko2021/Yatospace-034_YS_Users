package yatospace.jsp.user.io;

import java.util.List;

import yatospace.jsp.user.object.User;

/**
 * User storage functions specification. 
 * @author MV
 * @version 1.0
 */
public interface UserStorage {
	public void add(User user); 
	public void put(User user);
	public User get(String username); 
	public void remove(String username); 
	public List<User> list(); 
	public List<User> list(int pageNo, int pageSize);
}
