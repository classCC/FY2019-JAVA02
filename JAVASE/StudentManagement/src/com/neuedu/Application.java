package com.neuedu;

import java.util.Scanner;

import com.neuedu.pojo.Admin;
import com.neuedu.view.impl.UserViewImpl;

public class Application {

	public static void initDate(Admin[] admins){
		
		Admin admin=new Admin("admin","admin");
		admins[0]=admin;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		welcome();
		
		Admin[] admins=new Admin[5];
		initDate(admins);
		
		UserViewImpl application=new UserViewImpl();
		application.login(admins);
		
		
	}

	


	private static void welcome() {
		// TODO Auto-generated method stub
		System.out.println("========欢迎登陆学生管理系统========");
		System.out.println("1.登陆  2.退出");
		System.out.println("------------------------------------");
	}


	
	
}
