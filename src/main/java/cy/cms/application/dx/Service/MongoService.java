package cy.cms.application.dx.Service;

import java.util.List;

import cy.cms.application.dx.pojo.db;
import cy.cms.application.dx.pojo.mongo;

/**
 * 
 * 
 * @author 崔
 * @version mongodb
 * 
 *
 */

public interface MongoService {

	
	//增
	 public void saveUser(db db);
	//删
	
	//改
	
	//查
	 public db findUserByUserName(String userName);
	 public List<db> findAllName(String userName);
	 public List<mongo> findName(String title);
}
