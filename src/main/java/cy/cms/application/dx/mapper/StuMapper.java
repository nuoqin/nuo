package cy.cms.application.dx.mapper;


import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;


import com.github.pagehelper.Page;

import cy.cms.application.dx.pojo.Stu;



public interface StuMapper {
	
	
	//查
	@Select("SELECT * FROM stu")
	List<Stu> selectUsers(Integer page,Integer size);
	//查
	@Select("SELECT * FROM stu where id=(#{id})")
	Stu selectStyById(Long id);
	//增
	@Insert("insert into stu(name,age,sid) values(#{name}, #{age},#{sid})")
	void addStu(Stu stu);
	//删除
	@Delete("delete from stu where id=(#{id})")
	void delStu(Long id);
	//更新
	@Update("update stu set name=#{name},age=#{age},sid=#{sid} where id=(#{id})")
	void UpdateStu(Stu stu);
	
}
