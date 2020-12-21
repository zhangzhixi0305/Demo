package com.zhixi.service;

import com.zhixi.domain.User;
import com.zhixi.dao.UserDao;
import com.zhixi.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();

	@Override
	public User login(String name, String pass) {
		User entity = userDao.login(name, pass);
		return entity;
	}

	@Override
	public boolean insert(User entity) {
		return userDao.insert(entity);
	}

	@Override
	public boolean delete(User entity) {
		return userDao.delete(entity);
	}

	@Override
	public User findByName(String name){
		// TODO Auto-generated method stub
		return userDao.findByName(name);
	}

	@Override
	public boolean update(User entity) {
		// TODO Auto-generated method stub
		return userDao.update(entity);
	}
}
