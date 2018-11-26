package cy.cms.application.dx.util;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.Page;
/**
 * 
 * @author cui
 * @version layui 数据返回格式
 *
 */
public class Result implements Serializable{

	/**
	 * code 状态 成功返回0
	 * msg  提示 成功返回空
	 * count 总数
	 * data  返回参数
	 */
	private static final long serialVersionUID = 1L;
	private Integer code;
	private String msg;
	private Long count;
	private List<?> data;
	
	public Long getcount() {
		return count;
	}
	public void setcount(Long count) {
		this.count = count;
	}
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
