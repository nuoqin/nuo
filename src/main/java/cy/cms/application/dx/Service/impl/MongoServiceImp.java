package cy.cms.application.dx.Service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import cy.cms.application.dx.Service.MongoService;
import cy.cms.application.dx.pojo.db;
import cy.cms.application.dx.pojo.mongo;
/**
 * 
 * 
 * @author cui
 * @version mongodb逻辑
 *
 */
@Service
public class MongoServiceImp implements MongoService{

	@Autowired
	private MongoTemplate mt;
	
	@Override
	public void saveUser(db db) {
		// TODO Auto-generated method stub
		mt.save(db);
	}

	@Override
	public db findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		Query query=new Query();
		query.addCriteria(Criteria.where("username").is(userName));
		db db = mt.findOne(query, db.class, "db");
		return db ;
	}

	@Override
	public List<mongo> findName(String title) {
		// TODO Auto-generated method stub
		Query query=new Query(Criteria.where("title").is(title));
		
		List<mongo> list = mt.find(query, mongo.class);
		return list;
	}

	@Override
	public List<db> findAllName(String userName) {
		// TODO Auto-generated method stub
		Query query=new Query(Criteria.where("username").is(userName));
		
		List<db> list = mt.find(query, db.class,"db");
		
		return list;
	}

}
