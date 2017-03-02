package com.ittx.spring002.dao;

import java.util.List;

import com.ittx.spring002.model.Function;
import com.ittx.spring002.model.Module;
import com.ittx.spring002.model.Role;

public interface SecureDao {
	//==========module===============
	void addModule(Module module);
	List<Module> getAllModule(); 
	Module getModuleById(int id);
	
	//==========function===============
	void addFunction(Function function);
	List<Function> getAllFunction();
	List<Function> getFunction(int moduleId);
	
	//===========role===============
	void addRole(Role role);
	List<Role> getAllRoles();
	Role getRoleById(int id);
	void updateRole(Role role);
}
