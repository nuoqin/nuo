package cy.cms.application.dx.Controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aliyuncs.http.HttpRequest;
import com.aliyuncs.http.HttpResponse;

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
			String value = user.getUsername();
			//3.把用户信息放入redis缓存 key用户登录信息
			String key="login:token:"+user.getUsername();
			
			rs.setS(key, value);
			//4.返回静态界面
			return "user/index";
		}else{
			return "login";
		}
	}
	@RequestMapping("/login")
	public String login(HttpSession session){			
			return "login";		
	}
	@RequestMapping("/addStu")
	public String addStu(HttpSession session){	
		
			return "user/addStu";

	}
	@RequestMapping("/stu")
	public String stuList(HttpSession session){	
		
			return "user/stulist";
	}
	
}
