package cy.cms.application.dx.Controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;

import cy.cms.application.dx.Service.RedisService;
import cy.cms.application.dx.Service.UserService;
import cy.cms.application.dx.pojo.User;

@Controller
@CrossOrigin
public class UserController {

	@Autowired
	private UserService us;
	//StringRedisTemplate
	@Autowired
	private RedisService rs;
	@Value("${accessKeyId}")
	private String accessKeyId;
	
	@Autowired
	private HttpServletRequest request;
	
	private final static Logger log= LoggerFactory.getLogger(UserController.class);
	
	//后台界面
	@RequestMapping("/indexs")
	public String login(User user,HttpSession session,Model model,HttpServletResponse response){	 
		
		 Boolean result = us.getUser(user);
		 
		 if (result) {
			//session.setAttribute("user", user);
			//1.把token放入cookie
			Cookie cookie=new Cookie("token", user.getUsername());
			response.addCookie(cookie);
			//2.清除密码
			user.setPassword("");
			String value = user.toString();
			//3.把用户信息放入redis缓存 key用户登录信息
			String key="login:token:"+user.getUsername();
			
			rs.setO(key, value,1800);
			//4.返回静态界面
			System.out.println(accessKeyId);
			return "user/index";
		}else{
			return "login";
		}
	}
	//登录界面
		@RequestMapping("/")
		public String index(){
			
				//5.否返回登录界面
				
				return "login";			
		}
	//登录界面
	@RequestMapping("/login")
	public String login(){
		
			//5.否返回登录界面
			
			return "login";			
	}
	//修改登录信息
	@RequestMapping("/addStu")
	public String addStu(){	

		return "user/addStu";

	}
	//修改登录信息
	@RequestMapping("/stu")
	public String stu(){	

		return "user/stulist";

	}
	//聊天室
	@RequestMapping("/chat")
	public String chat(){	

		return "socket/chat";

	}
	//聊天室
		@RequestMapping("/send")
		public String send(){	

			return "socket/send";

		}
	@RequestMapping("/updateStu")
	public String updateStu(){	

		return "user/updateStu";

	}

}
