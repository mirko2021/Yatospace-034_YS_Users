package yatospace.jsp.user.web.util;

import java.io.Serializable;

/**
 * Navigation of the page. Blank is no navigation. 
 * @author MV
 * @version 1.0
 */
public class Navigation implements Serializable{
	private static final long serialVersionUID = -4062609475370580980L;
	
	private String navigationDestination = "";

	public String getNavigationDestination() {
		return navigationDestination;
	}

	public void setNavigationDestination(String navigationDestination) {
		if(navigationDestination==null) navigationDestination = ""; 
		this.navigationDestination = navigationDestination;
	}
	
	public void resetNavigationDestination() {
		this.navigationDestination = ""; 
	}
}
