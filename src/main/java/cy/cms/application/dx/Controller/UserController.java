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

import cy.cms.application.dx.Service.UserService;
import cy.cms.application.dx.pojo.User;

@Controller
@CrossOrigin
public class UserController {

	@Autowired
	private UserService us;
	
	@RequestMapping("/indexs")
	public String login(User user,HttpSession session,Model model,HttpServletResponse response){	 
		
		 Boolean result = us.getUser(user);
		 
		 if (result) {
			session.setAttribute("user", user);
			Cookie cookie=new Cookie("username", user.getUsername());
			response.addCookie(cookie);
			model.addAttribute("user", user.getUsername());
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
		User user1 = (User) session.getAttribute("user");
		if(user1!=null){
			return "user/addStu";
		}else{
			System.out.println("login");
			return "login";	
		}
		
		
	}
	@RequestMapping("/stu")
	public String stuList(HttpSession session){	
		User user1 = (User) session.getAttribute("user");
		if(user1!=null){
			return "user/stulist";
		}else{
			System.out.println("login");
			return "user/login";	
		}
		
		
	}
	
}
