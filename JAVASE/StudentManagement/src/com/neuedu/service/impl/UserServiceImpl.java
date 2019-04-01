package com.neuedu.service.impl;

import java.util.Scanner;

import com.neuedu.pojo.Admin;
import com.neuedu.service.UserService;

public class UserServiceImpl implements UserService {


	@Override
	public void addto(int id, String name, String sex, int age, String grade, String address, String email) {
		// TODO Auto-generated method stub
		System.out.println("******添加学生信息******");
		Scanner s=new Scanner(System.in);
		System.out.print("请输入学生id：");
		
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		
	}

}
