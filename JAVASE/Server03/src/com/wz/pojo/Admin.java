package com.wz.pojo;

public class Admin {

	public String username;//定义username变量
	public String password;//定义password变量
	
	//定义Admin初始化的输入参数
	public Admin(String username,String password){
		super();
		this.username=username;
		this.password=password;
	}
	
	
	public Admin(){
		
	}

	//get方法负责引用该类时的信息输出，而set方法就负责引用该类时的用户输入
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
