package com.ittx.spring002.model;

import java.util.Set;

/**
 * 一对多单向关连
 * 
 * 一端持有多端集合
 *
 */
public class Module {
	private int mId;
	private String name;
	private String description;
	private Set<Function> functionLists;
	
	public Module() {
	}

	public Module(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Module(int mId, String name, String description) {
		this.mId = mId;
		this.name = name;
		this.description = description;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Function> getFunctionLists() {
		return functionLists;
	}

	public void setFunctionLists(Set<Function> functionLists) {
		this.functionLists = functionLists;
	}

	@Override
	public String toString() {
		return "Module [mId=" + mId + ", name=" + name + ", description=" + description + "]";
	}
}
