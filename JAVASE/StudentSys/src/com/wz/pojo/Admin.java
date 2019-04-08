package com.wz.pojo;

import java.util.HashMap;
import java.util.Map;

//定义管理员类
public class Admin {

	public String username;//定义username变量
	public String password;//定义password变量
	
	//定义Admin初始化的输入参数
	public Admin(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	//定义一个数组用来存储系统用户
	public Admin(){
		Admin[] admin=new Admin[2];			//定义一个长度为二的admin数组
		Admin a=new Admin("admin","admin");	//定义一个用户admin，密码admin。
		admin[0]=a;					//把a保存到admin的第一个数组
		/*Map<String,Object> hashMap = new HashMap<>();
        //添加元素到 Map 中
        hashMap.put("username", "admin");
        hashMap.put("password", "admin");*/
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

