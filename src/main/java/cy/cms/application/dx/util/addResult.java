package cy.cms.application.dx.util;

import java.io.Serializable;
/**
 * 
 * 
 * @author cui
 * @version 添加成功
 */
public class addResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String status;
	private String msg;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
