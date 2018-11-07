package service.impl;

import org.junit.Test;

import service.UsersDAO;
import entity.Users;

public class TestUsersDAOImpl {

	@Test
	public void teseUsersLogin(){
		Users u=new Users(1,"zhurui","123456");
		UsersDAO udao=new UserDAOImpl();
		udao.usersLogin(u);
	}
}
