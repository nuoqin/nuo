package cy.cms.application.dx.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cy.cms.application.dx.Service.RedisService;
import cy.cms.application.dx.Service.UserService;
import cy.cms.application.dx.pojo.User;

@RestController
public class RedisController {

	//redis业务
	@Autowired
	private RedisService redisService;
	//User业务层
	@Autowired
	private UserService us;
	
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
	@RequestMapping("/delR")
	public void addUser(){
		
		redisService.delete("cui");
	}
	
	
}
