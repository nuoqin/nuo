package cy.cms.application.dx.Service;

import java.util.List;



import cy.cms.application.dx.pojo.Stu;
import cy.cms.application.dx.util.Result;

public interface StuService {
	//分页查看
	Result findStu(Integer page,Integer size);
	//根据id
	Stu selectById(Long id);
	//增
	void addStu(Stu stu);
	//删
	void delStu(Long id);
	//更新
	void updateStu(Stu stu);
}
