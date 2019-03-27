package com.abnormal.service;

import com.abnormal.exception.LoginException;
import com.abnormal.exception.RegisterException;

public interface UserBiz {

	//用户注册
	void register(String username, String password, String password2,String name, String email) 
					throws RegisterException;
					
	//用户登录
	void login(String username, String password) 
			throws LoginException;

	boolean isusernameexists(String username) throws LoginException;
	
	
}
