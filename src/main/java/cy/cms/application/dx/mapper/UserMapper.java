package cy.cms.application.dx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cy.cms.application.dx.pojo.User;

public interface UserMapper {
	
	//增
	@Insert("insert into user(username, password,pic_samll,email,createDate) values(#{username}, #{password},#{pic_samll},#{email},#{createDate}}")
	void insert(User user);
	//查
	@Select("SELECT * FROM user")
	List<User> selectUsers();
	//查询用户
	@Select("SELECT * FROM user where username=#{username}")
	User getUsers(String username);
	//修改密码
	@Update("update user set password=#{password}, where id=#{id}")
	void updatePassWord(String password,Integer id);
	//修改用户信息
	@Update("update user set pic_samll=#{pic_samll},email=#{email} where id=#{id}")
	void updateUser(User user,Integer id);
}
