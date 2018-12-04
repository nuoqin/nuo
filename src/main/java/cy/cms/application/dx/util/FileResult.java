package cy.cms.application.dx.util;
/**
 * 文件上传返回值
 */
import java.io.Serializable;

public class FileResult implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	private String url;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	

}
