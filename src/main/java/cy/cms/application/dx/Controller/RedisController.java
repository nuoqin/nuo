package cy.cms.application.dx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cy.cms.application.dx.Service.RedisService;

@RestController
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	
	@RequestMapping("/redis")
	public String get(){
		
		String cc="login:token:cui";
		cc=redisService.getS(cc);
		return cc;
	}
	@RequestMapping("/addR")
	public void set(){
		
		String key="login:token:cui";
		String value="崔伟杰";
		redisService.setS(key, value);
	}
}
