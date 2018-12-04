package cy.cms.application.dx.Service.impl;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
/**
 * @author 崔
 *  操作redis业务
 * 
 */
import org.springframework.stereotype.Service;

import cy.cms.application.dx.Service.RedisService;
import cy.cms.application.dx.pojo.User;
@Service
public class RedisSeriviceImp implements RedisService{

	//对象序列化 插入对象
	@Autowired
	private RedisTemplate<String, Object> otrt; 
	//字符串序列化 插入字符串
	@Autowired
	private StringRedisTemplate srt;
	/**
	 * @param value redis的值 
	 */
	//插入字符串
	@Override
	public void setO(String key,String user,long time) {
		// TODO Auto-generated method stub
		srt.opsForValue().set(key, user, 1800, TimeUnit.SECONDS);
	}
	
	//插入字符串
	@Override
	public void setS(String key,String value) {
		// TODO Auto-generated method stub
		srt.opsForValue().set(key, value);
	}
	/**
	 * @param value redis的key 
	 */
	//根据key查找
	@Override
	public String getS(String key) {
		// TODO Auto-generated method stub
		String cc = (String) srt.opsForValue().get(key);
		return cc;
	}

	@Override
	public void delete(String key) {
		// TODO Auto-generated method stub
		srt.delete(key);
		
	}

}
