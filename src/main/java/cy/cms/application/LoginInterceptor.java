package cy.cms.application;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



/**
 * 
 * @author   cui
 * @version  登录拦截拦截器
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	@Autowired
	private StringRedisTemplate rs;
	
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
		//情况一
		//1.获取session
		//HttpSession session=request.getSession();
		//2.获取session里的用户
		//User user = (User) session.getAttribute("user");
		//情况二
		
		//1.取出cookie里的用户
		Cookie[] cookies = request.getCookies();
		String username="";
		if(cookies==null && cookies.equals("null") && cookies.length<1){
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
		}
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("token")){
				username=cookie.getValue();
				//System.out.println(username);
			}
		}

		//2.从redis里取出用户信息
		String key="login:token:"+username;
		System.out.println(key);
		String user = rs.opsForValue().get(key);
		//System.out.println(key);
		System.out.println(user);
		//3.判断用户是否过期
		if(user!=null && !(user.equals(""))){
			//4.是通过
			//System.out.println(user.getUsername()+"1");
			return true;
		}else{
			//5.否返回登录界面
			System.out.println("2");
			response.sendRedirect(request.getContextPath()+"/login");
			return false;
			
		}
		
		
	}

}
