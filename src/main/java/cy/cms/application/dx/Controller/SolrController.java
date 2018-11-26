package cy.cms.application.dx.Controller;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/solr")
public class SolrController {

	//@Autowired
   // private SolrClient client;
	
	//@Autowired
	//private TGoodsService tgs;
	
	//@RequestMapping("/find")
	//public SolrDocumentList getSolr(String search) throws SolrServerException, IOException{
		    
			//1.新建查询
//			SolrQuery query=new SolrQuery();
//			//2.设置查询语句
//			query.setQuery("titles:钢*");
//			//3.设置排序方法
//			query.addSort("id", SolrQuery.ORDER.asc);
//			//4.设置返回结果 从0开始 每次2个
//			query.setStart(0);
//			query.setRows(2);
//			 //sd=client.getById("1");
//			//开始查询
//			QueryResponse response = client.query(query);
//			//返回结果
//			SolrDocumentList result = response.getResults();
//			//System.out.println(sd.toString());
//
		//    return  null;
	//}
	
	//@RequestMapping("/setAll")
//	public String setSolr() throws SolrServerException, IOException{
		 
	//List<ChildTGoods> list = //tgs.getGoods();
		
	//	for (ChildTGoods childTGoods : list) {
			
	//		SolrInputDocument  sd=new SolrInputDocument ();
	//		sd.setField("id", childTGoods.getRid());
	//		sd.setField("titles", childTGoods.getTitles());
	//		sd.setField("c_xinghao", childTGoods.getC_xinghao());
	//		sd.setField("producttype", childTGoods.getProducttype());
	//		sd.setField("c_address", childTGoods.getC_address());
	//		sd.setField("multipleprice", childTGoods.getMultipleprice());
	//		client.add("collection1",sd);
	//		client.commit("collection1");
	//	}
		

	//	    return  "ok";
	//}
	
	/**
     * 根据id删除索引
     * @param id
     * @return
     */
   // @RequestMapping("delete")
   // public String delete(String id)  {
//        try {
//            client.deleteById("collection1",id);
//            client.commit("collection1");
//            return id;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
     //   return "error";
  //  }
}
