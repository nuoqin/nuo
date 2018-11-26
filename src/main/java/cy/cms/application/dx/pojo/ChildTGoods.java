package cy.cms.application.dx.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ChildTGoods implements Serializable{
  
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 
	//商品id
	 private Integer rid;
	 //商品名称
	 private String titles;
	//商品型号
	 private String c_xinghao;
	 private String producttype;
	 private String c_address;
	 private Double multipleprice;
	 
	 
	 
	    public String getC_xinghao() {
			return c_xinghao;
		}
		public void setC_xinghao(String c_xinghao) {
			this.c_xinghao = c_xinghao;
		}
		public String getC_address() {
			return c_address;
		}
		public void setC_address(String c_address) {
			this.c_address = c_address;
		}
	
	    public String getProducttype() {
			return producttype;
		}
		public void setProducttype(String producttype) {
			this.producttype = producttype;
		}
		public Integer getRid() {
			return rid;
		}
		public void setRid(Integer rid) {
			this.rid = rid;
		}
		public String getTitles() {
			return titles;
		}
		public void setTitles(String titles) {
			this.titles = titles;
		}
		public Double getMultipleprice() {
			return multipleprice;
		}
		public void setMultipleprice(Double multipleprice) {
			this.multipleprice = multipleprice;
		}
		
		
	
	 
}