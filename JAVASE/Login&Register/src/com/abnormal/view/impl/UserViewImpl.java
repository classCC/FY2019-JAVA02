package com.abnormal.view.impl;

import com.abnormal.view.UserView;

import java.util.Scanner;

import com.abnormal.service.UserBiz;
import com.abnormal.service.impl.UserBizImpl;

public class UserViewImpl implements UserView {

	UserBiz userBiz=new UserBizImpl();
	
	
	public void login() {
		// TODO Auto-generated method stub
		
		Scanner s=new Scanner(System.in);
		
		System.out.print("请输入用户名:");
		String username=s.next();
		
		boolean usernameexists=userBiz.isusernameexists(username);
		if(usernameexists) {
			System.out.print("请输入密码:");
			String password=s.next();
			userBiz.login(username, password);
		}

	}

	public void register() {
		// TODO Auto-generated method stub

	}

}
