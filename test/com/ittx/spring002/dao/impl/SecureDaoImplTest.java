package com.ittx.spring002.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ittx.spring002.dao.SecureDao;
import com.ittx.spring002.model.Function;
import com.ittx.spring002.model.Module;
import com.ittx.spring002.model.Role;

public class SecureDaoImplTest {
	private SecureDao secureDao;

	@Before
	public void before() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		secureDao = (SecureDao) ctx.getBean("secureDao");
	}

	@Test
	public void testAddModule() {
		Module module = new Module("车辆管理", "此模块管理车辆信息");
		secureDao.addModule(module);
	}

	@Test
	public void testGetAllModule() {
		List<Module> lists = secureDao.getAllModule();
		for (Module module : lists) {
			System.out.println(module);
		}
	}

	@Test
	public void testAddFunction() {
		Module module = secureDao.getModuleById(1);
		Function function = new Function("vehicle_add.do", "添加车辆信息", module);
		secureDao.addFunction(function);
		
	}
	
	@Test
	public void testAddRole() {
		Role role = new Role("一级管理员","具有车辆管理功能");
		secureDao.addRole(role);
	}
	
	@Test
	public void testUpdateRole(){
		Role role = secureDao.getRoleById(1);
		role.setName("二级管理员");
		secureDao.updateRole(role);
	}
	
	@Test
	public void testSetFuntionToRole() {
		Role role = secureDao.getRoleById(1);
		List<Function> functionLists = secureDao.getFunction();
		
		Set<Function> functionSets = new HashSet<Function>();
		for(Function function : functionLists){
			functionSets.add(function);
		}
		
		role.setFunctionLists(functionSets);
		
		secureDao.updateRole(role);
	}

}
