package com.neuedu.view.impl;

import java.util.Scanner;

import com.neuedu.pojo.Admin;
import com.neuedu.view.UserView;

public class UserViewImpl implements UserView {

	public void login1(Admin[] admins) {
		// TODO Auto-generated method stub
		System.out.println("欢迎 登陆！");
		
		Scanner s=new Scanner(System.in);
		System.out.println("请输入用户名");
		String username=s.nextLine();
		System.out.println("请输入密码");
		String password=s.nextLine();
		for(int i=0;i<admins.length;i++){
			Admin admin=admins[i];
			
			if(admin==null){
				continue;
			}else if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
				System.out.println("欢迎你"+username);
				operation();
				break;
			}else {
				System.out.println("输入有误，请重新输入。");
				login1(admins);
			}
		}
	}
	
	public void operation() {
		System.out.println("***************请选择要操作的信息对应的数字**************");
		System.out.println("*1.查看学生信息 2.添加学生信息 3.删除学生信息 4.修改学生信息 5.退出*");
		System.out.println("************************************************");
		Scanner s=new Scanner(System.in);
		System.out.println("请选择：");
		int operation=s.nextInt();
		
		if(operation==1) {
			
		}else if(operation==2) {
			addto();
		}else if(operation==3) {
			
		}else if(operation==4) {
			
		}else if(operation==5) {
			
		}else {
			System.out.println("输入有误，请重新输入。");
			operation();
		}
	}
	
	@Override
	public void login(Admin[] admins) {
		// TODO Auto-generated method stub
		
		//接受键盘输入获取username,password
		Scanner s=new Scanner(System.in);
		System.out.println("请选择：");
		int login=s.nextInt();
		
		if(login==1) {
			//登陆
			login1(admins);
		}else if(login==2){
			//退出
		}else {
			System.out.println("输入有误，请重新输入。");
			login(admins);
		}
	}
	
	
	@Override
	public void addto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		
	}


	
	

}
