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
import com.ittx.spring002.utils.Utils;

public class SecureDaoImplTest {
	private SecureDao secureDao;
	
	/**
	 * 加载spring核心配置文件applicationContext.xml
	 * 根据applicationContext.xml中配置由spring容器实例相关bean,同时扫描指定包，实例化注解类
	 */
	@Before
	public void before() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		secureDao = (SecureDao) ctx.getBean("secureDao");
	}

	/**
	 * 新建添加模块
	 */
	@Test
	public void testAddModule() {
		Module module = new Module("类型管理", "对同学类型进行管理");
		secureDao.addModule(module);
	}
	/**
	 * 查询所有模块
	 */
	@Test
	public void testGetAllModule() {
		List<Module> lists = secureDao.getAllModule();
		for (Module module : lists) {
			System.out.println(module);
		}
	}
	/**
	 * 添加功能
	 */
	@Test
	public void testAddFunction() {
		Module module = secureDao.getModuleById(1);
		Function function = new Function("vehicle_list.do", "车辆列表信息", module);
		secureDao.addFunction(function);
	}
	
	/**
	 * 查询指定模块下的所有功能
	 */
	@Test
	public void testGetAllFunctionByModule(){
		List<Function> functionLists = secureDao.getFunction(1);
		for(Function f:functionLists){
			System.out.println(f);
		}
	}
	
	@Test
	public void testAddRole() {
		Role role = new Role("一级管理员","操作所有车辆管理功能");
		secureDao.addRole(role);
	}
	
	@Test
	public void testGetAllRole(){
		List<Role> lists = secureDao.getAllRoles();
		for(Role r:lists){
			System.out.println(r);
		}
	}
	
	@Test
	public void testUpdateRole(){
		Role role = secureDao.getRoleById(1);
		role.setName("二级管理员");
		secureDao.updateRole(role);
	}
	
	/**
	 * 给角色指定功能
	 */
	@Test
	public void testSetFuntionToRole() {
		Role role = secureDao.getRoleById(1);  //一级管理员
		
		List<Function> functionLists = secureDao.getAllFunction();  //所有功能
		
		role.setFunctionLists(Utils.listToSet(functionLists));
		
		secureDao.updateRole(role);
	}

}
