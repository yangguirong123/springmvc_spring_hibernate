package com.ittx.spring002.model;

public class User {
	private int id;
	private String name;
	private int number;

	public User() {
	}

	public User(String name, int number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id="+id+" ,name=" + name + ", number=" + number + "]";
	}

}
