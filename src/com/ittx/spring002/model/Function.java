package com.ittx.spring002.model;

import java.util.Set;

/**
 * 多对一的单向关连 
 * 
 * 多端持有一端实例
 *
 */
public class Function {
	private int fId;
	private String code; //user_add.do
	private String description;
	private Module module;
	private Set<Role> roleLists;

	public Function(String code, String description, Module module) {
		this.code = code;
		this.description = description;
		this.module = module;
	}

	public Function() {
	}

	public Function(int fId, String code, String description, Module module) {
		this.fId = fId;
		this.code = code;
		this.description = description;
		this.module = module;
	}

	public int getfId() {
		return fId;
	}

	public void setfId(int fId) {
		this.fId = fId;
	}


	public String getDescription() {
		return description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Set<Role> getRoleLists() {
		return roleLists;
	}

	public void setRoleLists(Set<Role> roleLists) {
		this.roleLists = roleLists;
	}

	@Override
	public String toString() {
		return "Function [fId=" + fId + ", code=" + code + ", description=" + description + ", module=" + module + "]";
	}

}
