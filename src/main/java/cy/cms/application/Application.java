package cy.cms.application;

import java.util.Properties;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.github.pagehelper.PageHelper;
/**
 * 
 * 
 * @author cui
 * @since 2018-11-28 整合redis 导入sso
 *
 */

@MapperScan("cy.cms.application.dx.mapper")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	//配置mybatis的分页插件pageHelper
     @Bean
     public PageHelper pageHelper(){
         PageHelper pageHelper = new PageHelper();
         Properties properties = new Properties();
         properties.setProperty("offsetAsPageNum","true");
         properties.setProperty("rowBoundsWithCount","true");
         properties.setProperty("reasonable","true");
         //配置mysql数据库的方言
         properties.setProperty("dialect","mysql");    
         pageHelper.setProperties(properties);
         return pageHelper;
     }
  
}
