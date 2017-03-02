package com.ittx.spring002.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ittx.spring002.dao.SecureDao;
import com.ittx.spring002.model.Function;
import com.ittx.spring002.model.Module;
import com.ittx.spring002.model.Role;
import com.ittx.spring002.utils.MyHibernateDaoSupport;
import com.ittx.spring002.utils.Utils;

@Repository("secureDao")
@Transactional
public class SecureDaoImpl extends MyHibernateDaoSupport implements SecureDao {

	@Override
	public void addModule(Module module) {
		getHibernateTemplate().save(module);
	}

	@Override
	public List<Module> getAllModule() {
		return (List<Module>) getHibernateTemplate().find("FROM Module");
	}

	@Override
	public void addFunction(Function function) {
		getHibernateTemplate().save(function);
	}

	@Override
	public List<Function> getAllFunction() {
		return (List<Function>) getHibernateTemplate().find("FROM Function");
	}

	@Override
	public Module getModuleById(int id) {
		return getHibernateTemplate().get(Module.class, id);
	}

	@Override
	public void addRole(Role role) {
		getHibernateTemplate().save(role);

	}

	@Override
	public List<Role> getAllRoles() {
		return (List<Role>) getHibernateTemplate().find("FROM Role");
	}

	@Override
	public Role getRoleById(int id) {
		return getHibernateTemplate().get(Role.class, id);
	}

	@Override
	public void updateRole(Role role) {
		getHibernateTemplate().update(role);
	}

	@Override
	public List<Function> getFunction(int moduleId) {
//		List<Function> lists = (List<Function>) getHibernateTemplate()
//				.find("FROM Function as f WHERE f.module.mId = " + moduleId );
//		return lists;

		 Module module = getHibernateTemplate().get(Module.class, moduleId);
		 Set<Function> sets =  module.getFunctionLists();
		 return Utils.setToList(sets);
	}

}
