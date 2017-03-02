package com.ittx.spring002.server.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ittx.spring002.dao.UserDao;
import com.ittx.spring002.model.User;
import com.ittx.spring002.server.UserServer;
import com.ittx.spring002.utils.Pager;
/**
 * 
 * @Transactional
 * 该类下所有public修饰的方法都将开启事务
 *
 */
@Service("userServer")
@Transactional
public class UserServerImpl implements UserServer {
	/**
	 * 业务层注入Dao实例，dao实例必须声明为接口
	 */
	@Autowired
	private UserDao userDao;
	
	/**
	 * @Transactional(propagation = Propagation.NOT_SUPPORTED)
	 * 该方法不开事务
	 */
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> getUserLists() {
		return userDao.getUserLists();
	}

	@Override
	public void deleteUser(User user) {
		userDao.deleteUser(user);
		
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userDao.getUserById(id);
	}

	@Override
	public List<User> getPageUserLists(Pager pager) {
		return userDao.getPageUserLists(pager);
	}

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return userDao.getTotalCount();
	}

}
