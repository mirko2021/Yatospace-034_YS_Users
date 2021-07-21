package yatospace.jsp.user.toolkit;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Content encoding. 
 * @author MV
 * @version 1.0
 */
public final class ContentEncoding {
	private ContentEncoding() {}
	
	public static String encodeURI(String text) {
		try {
			return URLEncoder.encode(text,"UTF-8"); 
		}catch(Exception ex) {
			return null;
		}
	}
	
	public static String decodeURI(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8"); 
		}catch(Exception ex) {
			return null; 
		}
	}
	
	public static String encodeHTML(String text) {
		return text.replaceAll("&", "&amp;").replaceAll("<", "&lt").replaceAll(">", "&gt;").replaceAll("\"", "&quot;").replaceAll("\'", "&apos;"); 
	}
	
	public static String decodeHTML(String text) {
		return text.replaceAll("&apos;", "\'").replaceAll("&quot;", "\"").replaceAll("&gt;", ">").replaceAll("&lt;", "<").replaceAll("&amp;", "&");
	}
}
