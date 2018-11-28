package cy.cms.application;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cy.cms.application.dx.pojo.User;

/**
 * 
 * @author   cui
 * @version  登录拦截拦截器
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 用户登录拦截 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		
		//1.获取session
		HttpSession session=request.getSession();
		//2.获取session里的用户
		User user = (User) session.getAttribute("user");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			System.out.println(cookie.getName()+"---->"+cookie.getValue());
		}
		//1.
		//2.
		//3.
		
		//3.判断用户是否过期
		if(user!=null){
			//4.是通过
			System.out.println(user.getUsername()+"1");
			return true;
		}else{
			//5.否返回登录界面
			System.out.println("2");
			
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
			
		}
		
		
	}

}
