package yatospace.jsp.user.util;

import javax.servlet.http.HttpSession;

/**
 * HttpSession representation with basic descriptor. 
 * @author MV
 * @version 1.0
 */
public class BasicHttpSessionRepresentation implements SessionRepresentation{
	private BasicSessionDescriptor descriptor = new BasicSessionDescriptor();
	private HttpSession session; 
	
	public BasicHttpSessionRepresentation(HttpSession session) {
		if(session==null) throw new NullPointerException();
		this.session = session; 
		this.descriptor.setGeneralId(session.getId());
		this.descriptor.setLocalId(session.getId());
	}
	
	@Override
	public BasicSessionDescriptor getDescriptor() {
		return descriptor;
	}

	public HttpSession getSession() {
		return session;
	}
}
