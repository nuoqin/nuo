package cy.cms.application.dx.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 
 * @author nuoqin
 * @since 2018/12/4
 *	@version 我的博客界面展示
 */
@Controller
@CrossOrigin
@RequestMapping("/my")
public class BlogController {

	/**
	 * 
	 * @return 
	 */
	@GetMapping("/index")
	public String blogIndex(){
		
		return "my/index";
	}
	
	
}
