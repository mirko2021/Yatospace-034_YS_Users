package yatospace.jsp.user.web.bean;

import java.io.Serializable;

/**
 * Bean for pagging.
 * @author MV
 * @version 1.0
 */
public class PaggingBean implements Serializable{
	private static final long serialVersionUID = -7901952390786128432L;
	
	private int pageNo = 1;
	private int pageSize = 20;
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		if(pageNo < 0) pageNo = 0;
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		if(pageSize < 1) pageSize = 1; 
		this.pageSize = pageSize;
	}
	public void next(int pageNo) {
		setPageNo(pageNo+1); 
	}
	public void previous(int pageNo) {
		setPageNo(pageNo-1);
	}
	public void refresh(int pageNo) {
		setPageNo(pageNo);
	}
}
