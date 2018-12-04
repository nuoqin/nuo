package cy.cms.application.dx.Service;

import cy.cms.application.dx.pojo.User;

public interface RedisService {

	//字符串
	void setS(String key,String value);
	
	//得到字符串
	String getS(String key);
	
	//对象
	void setO(String key,String user,long time);
	
	//删除
	void delete(String key);
	
}
