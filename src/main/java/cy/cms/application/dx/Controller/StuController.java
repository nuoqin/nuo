package cy.cms.application.dx.Controller;

import javax.validation.constraints.Null;

import org.apache.http.cookie.SM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.Page;

import cy.cms.application.dx.Service.StuService;
import cy.cms.application.dx.pojo.Stu;
import cy.cms.application.dx.util.Result;
import cy.cms.application.dx.util.addResult;

@RestController
@RequestMapping("/stus")
public class StuController {

	@Autowired
	private StuService ss;
	
	//分页查看
	@RequestMapping("/list")
	public Result find(Integer page, Integer limit){
		System.out.println(limit);
		page = page==null ? 1 : page;
		limit = limit==null ? 5 : limit;
		System.out.println(limit);
		return ss.findStu(page, limit);	
	}
	//添加学生信息
	@RequestMapping("/add")
	public addResult add(@RequestBody  Stu stu){
		
		addResult result=new addResult();
		System.out.println(stu.getSid());
		result.setStatus("1");
			if(stu!=null && !(stu.getName().equals(""))){				
				ss.addStu(stu);
				result.setMsg("添加完成");
				return result;	
			}else{
				result.setMsg("添加失败");
				return result;		
			}
	
	}
	//查找学生信息
	@RequestMapping("/findStu/{id}")
	public Stu findStu(@PathVariable Long id){
		
		Stu stu = ss.selectById(id);
		
		return stu;
	}
	//修改学生信息
	@RequestMapping("/update")
	public String updateStu(@RequestBody Stu stu){
		
		System.out.println(stu.getName());
		ss.updateStu(stu);
		return "ok";
	}
	//删除学生信息
		@RequestMapping("/delStu/{id}")
		public addResult delStu(@PathVariable Long id){
			addResult result=new addResult();
			System.out.println(id);
			if(id!=null){
				ss.delStu(id);
				result.setStatus("1");
				result.setMsg("删除成功");
				return result;
			}else{
				result.setStatus("0");
				result.setMsg("删除失败");
				return result;
				
			}
			
		}
	
}
