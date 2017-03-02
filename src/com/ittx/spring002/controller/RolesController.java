package com.ittx.spring002.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ittx.spring002.dao.SecureDao;
import com.ittx.spring002.model.Role;

@Controller
public class RolesController {
	@Autowired
	private SecureDao secureDao;
	
	@RequestMapping("role_list")
	public String getRoleList(Map<String,List<Role>> map){
		List<Role> roleLists = secureDao.getAllRoles();
		map.put("rolesList", roleLists);
		return "role_list";
	}
}
