package cy.cms.application;
/**
 *  @author cui
 * 	@version 拦截器配置注册
 */

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter{
	 
		public WebConfig(){
	        super();
	    }
		/**
		 * 静态资源释放
		 */
		@Override
	    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	       // registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");

	        super.addResourceHandlers(registry);  
	    }
		/**
		 * 拦截请求
		 */
	    @Override
	    public void addInterceptors(InterceptorRegistry registry) {
	        //拦截规则：除了/indexs，/login其他都拦截判断
	        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/indexs");
	        super.addInterceptors(registry);
	    }

}
