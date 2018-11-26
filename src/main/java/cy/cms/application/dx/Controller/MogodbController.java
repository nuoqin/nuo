package cy.cms.application.dx.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cy.cms.application.dx.Service.MongoService;
import cy.cms.application.dx.pojo.db;
import cy.cms.application.dx.pojo.mongo;

@RestController
public class MogodbController {

	@Autowired
	private MongoService ms;
	
	@RequestMapping("/mongo")
	public void mo(){
		db db=new db();
		db.setId(1);
		db.setPassword("1234560");
		db.setUsername("cui");
		ms.saveUser(db);
	}
	
	
	@RequestMapping("/getdb")
	public db t(){
		db list = ms.findUserByUserName("cui");
		return list;
	}
	
	
	@RequestMapping("/getMongo")
	public List<mongo> mos(){
		 
		return ms.findName("cui");
	}
	
	@RequestMapping("/list")
	public List<db> list(){
		List<db> list = ms.findAllName("cui");
		return list;
	}
	
}
