package com.user.services;

import com.user.beans.User;
import com.user.beans.UserInfo;
import com.user.daos.UserDao;

public class UserService {
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public String sayHello(User user){
		return "Hello, "+user.getName()+" with Age "+user.getAge()+ " this is the sample of Spring MVC + Hibernate";
	}
	
	public UserInfo process(User user){
		userDao.save(user);
		UserInfo userInfo = new UserInfo();
		userInfo.setMessage(this.sayHello(user));
		userInfo.setUsers(userDao.query());
		return userInfo;
	}
}
