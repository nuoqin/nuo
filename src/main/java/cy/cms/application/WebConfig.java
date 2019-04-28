package cy.cms.application;
/**
 *  @author cui
 * 	@version 拦截器配置注册
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	 
		public WebConfig(){
	        super();
	    }
		//问题：拦截器注入容器失败？1.拦截器bean化
		@Bean
		public LoginInterceptor LoginInterceptor(){
			
			return new LoginInterceptor();
		}
		
		/**
		 * 静态资源释放
		 */
		@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	       // registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
	        //图片路径映射
	        registry.addResourceHandler("/img/**").addResourceLocations("file:D:/img/");
	        super.addResourceHandlers(registry);  
	        
	        
	    }
		/**
	     * 默认访问页面	
	     */
	    @Override
		public void addViewControllers(ViewControllerRegistry registry) {
	    	
	    	registry.addViewController( "/" ).setViewName( "login" );
	        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
	        super.addViewControllers(registry);
		}
		/**
		 * 拦截请求
		 */
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        //拦截规则：除了/indexs，/login其他都拦截判断 这里最好不要new 负责注入无效
	        registry.addInterceptor(LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/","/login");
	        super.addInterceptors(registry);
	    }
	    

}
