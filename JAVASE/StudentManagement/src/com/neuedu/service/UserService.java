package com.neuedu.service;

import com.neuedu.pojo.Admin;

public interface UserService {

	 //添加学生信息
	 void addto(int id,String name,String sex,int age,
			 String grade,String address,String email);
	 //修改学生信息
	 void change();
}
