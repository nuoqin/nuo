package cy.cms.application.dx.Service;

import java.util.List;


import cy.cms.application.dx.pojo.User;

public interface UserService {

	//增
	void insert(User user);
	//查
	List<User> select();
	//查用户
	Boolean getUser(User user);
	//修改密码
	void updatePassWord(String password, Integer id);
	
}
