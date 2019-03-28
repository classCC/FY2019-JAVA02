package com.neuedu.view;

import com.neuedu.pojo.Admin;

public interface UserView {
	
	
	//管理员登陆
	void login(Admin[] admins);
	//添加学生信息
	void addto();
	//修改学生信息
	void change();
	
}
