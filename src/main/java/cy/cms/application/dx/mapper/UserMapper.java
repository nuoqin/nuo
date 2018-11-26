package cy.cms.application.dx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import cy.cms.application.dx.pojo.User;

public interface UserMapper {
	
	//增
	@Insert("insert into user(username, password) values(#{username}, #{password}")
	void insert(User user);
	//查
	@Select("SELECT * FROM user")
	List<User> selectUsers();
	
	@Select("SELECT * FROM user where username=#{username}")
	User getUsers(String username);
}
