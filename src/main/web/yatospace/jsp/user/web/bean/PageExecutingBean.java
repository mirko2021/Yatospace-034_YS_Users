package yatospace.jsp.user.web.bean;

import java.io.Serializable;

import yatospace.jsp.user.web.util.Navigation;
import yatospace.jsp.user.web.util.Status;

/**
 * Зрна којима се води основне страври у току извршавања захтјева за 
 * неком комплексном страницом која је комплексна у смислу укључења и 
 * искључења дијелвоа, а ти дијелови се вежу за једну или више компоненти. 
 * @author MV
 * @version 1.0
 */
public class PageExecutingBean implements Serializable{
	private static final long serialVersionUID = -5051052978404706173L;
	private Navigation navigation = new Navigation(); 
	private Status status = new Status();
	
	public Navigation getNavigation() {
		return navigation;
	}
	
	public Status getStatus() {
		return status;
	}
}
