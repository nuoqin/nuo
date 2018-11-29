package cy.cms.application.dx.Service.impl;
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
@Service
public class RedisSeriviceImp implements RedisService{

	@Autowired
	private RedisTemplate<String, Object> redis; 
	@Autowired
	private StringRedisTemplate srt;
	/**
	 * @param value redis的值 
	 */
	@Override
	public void setS(String key,String value) {
		// TODO Auto-generated method stub
		srt.opsForValue().set(key, value);
	}
	/**
	 * @param value redis的key 
	 */
	@Override
	public String getS(String key) {
		// TODO Auto-generated method stub
		String cc = (String) srt.opsForValue().get(key);
		return cc;
	}

}
