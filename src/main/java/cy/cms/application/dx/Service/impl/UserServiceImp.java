package cy.cms.application.dx.Service.impl;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cy.cms.application.dx.Service.UserService;
import cy.cms.application.dx.mapper.UserMapper;
import cy.cms.application.dx.pojo.User;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	private UserMapper um;
	
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub
		um.insert(user);	
	}

	@Override
	public List<User> select() {
		// TODO Auto-generated method stub
		List<User> list = um.selectUsers();
		return list;
	}

	@Override
	public Boolean getUser(User user) {
		// TODO Auto-generated method stub
		String username = user.getUsername();
		User user2 = um.getUsers(username);
			
			if(user2==null){
				return false;
			}
			if(!user2.getPassword().equals(user.getPassword())){
				return false;
			}
		return true;
	}

	
}
