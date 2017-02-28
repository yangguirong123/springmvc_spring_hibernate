package com.ittx.spring002.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ittx.spring002.model.User;
import com.ittx.spring002.server.UserServer;
import com.ittx.spring002.utils.Pager;

@Controller
@RequestMapping("/user")
public class UserController {
	private int mCurrentPager = 1; //当前页
	/**
	 * 控制层注入业务实例，业务实例必须声明为接口
	 */
	@Autowired
	private UserServer userServer;

	@RequestMapping("/add")
	public String addUser(User user, Model model){
		userServer.addUser(user);
		return "redirect:/user/list.do";
	}

	@RequestMapping("/list")
	public String findAll(Integer page,Map<String, Object> map) {
//		List<User> userLists = userServer.getUserLists();
	
		if(page != null && page > 0){
			mCurrentPager = page;
		}
		
		Pager pager = new Pager(userServer.getTotalCount(),mCurrentPager);
		pager.setUrl("http://localhost:8080/SpringWeb02_struts2_spring_jdbcTemplate/user/list.do");
		
		map.put("url", pager.getPageStr());
		
		List<User> userLists = userServer.getPageUserLists(pager);
		map.put("userLists", userLists);

		return "list_user";
	}
	
	
	@RequestMapping("/delete")
	public String deleteUser(Integer id){
		User user = userServer.getUserById(id);
		userServer.deleteUser(user);
		return "redirect:/user/list.do";
	}
	
	@RequestMapping("/update")
	public String updateUser(String name){
		System.out.println("name  :"+name);
		return "redirect:/user/list.do";
	}
	

}
