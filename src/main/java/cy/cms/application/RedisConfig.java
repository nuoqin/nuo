package cy.cms.application;

import org.springframework.cache.CacheManager; 
import org.springframework.cache.annotation.EnableCaching; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.data.redis.cache.RedisCacheManager; 
import org.springframework.data.redis.connection.RedisConnectionFactory; 
import org.springframework.data.redis.core.RedisTemplate; 
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration 
@EnableCaching
public class RedisConfig {

	
	@Bean 
	  public CacheManager cacheManager(RedisTemplate<?,?> redisTemplate) { 
	   CacheManager cacheManager = new RedisCacheManager(redisTemplate); 
	   return cacheManager; 
	  } 
		//默认jdk序列方式我们可以用来保存对象
	  @Bean 
	  public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) { 
	   RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>(); 
	   redisTemplate.setConnectionFactory(factory); 
	   return redisTemplate; 
	  }
	  //默认string的序列化方式 专门用于存储string格式
	  @Bean 
	  public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory factory) { 
	   StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(); 
	   stringRedisTemplate.setConnectionFactory(factory); 
	   return stringRedisTemplate; 
	  }
	
	
	
}
