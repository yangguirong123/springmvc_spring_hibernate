package com.ittx.spring002.daoimpl;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ittx.spring002.model.User;
import com.ittx.spring002.server.UserServer;

public class UserDaoImplTest {

	@Test
	public void test() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserServer userServer = (UserServer) ctx.getBean("userService");
		
		List<User> lists = userServer.getUserLists();
		for(User user:lists){
			System.out.println(user);
		}
		
	}

}
