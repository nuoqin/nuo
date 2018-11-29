package cy.cms.application.dx.Service;


public interface RedisService {

	//字符串
	void setS(String key,String value);
	
	//得到字符串
	String getS(String key);
	
	
}
