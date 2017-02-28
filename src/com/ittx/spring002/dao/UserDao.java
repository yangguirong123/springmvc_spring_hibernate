package com.ittx.spring002.dao;

import java.util.List;

import com.ittx.spring002.model.User;
import com.ittx.spring002.utils.Pager;

public interface UserDao {
	public void addUser(User user);
	public List<User> getUserLists();
	public List<User> getPageUserLists(Pager pager);
	public void deleteUser(User user);
	public User getUserById(int id);
	public int getTotalCount();
}
