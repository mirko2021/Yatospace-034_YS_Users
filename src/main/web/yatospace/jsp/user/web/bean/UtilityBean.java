package yatospace.jsp.user.web.bean;

import yatospace.jsp.user.toolkit.ContentEncoding;

/**
 * Bean for utillity functionals. 
 * @author MV
 * @version 1.0
 */
public class UtilityBean {
	public String encodeHTML(String encode) {
		return ContentEncoding.encodeHTML(encode);
	}
}
