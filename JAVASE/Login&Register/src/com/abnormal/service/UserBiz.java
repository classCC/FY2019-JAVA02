package com.abnormal.service;

import com.abnormal.exception.LoginException;
import com.abnormal.exception.RegisterException;

public interface UserBiz {

	//�û�ע��
	void register(String username, String password, String password2,String name, String email) 
					throws RegisterException;
					
	//�û���¼
	void login(String username, String password) 
			throws LoginException;

	boolean isusernameexists(String username) throws LoginException;
	
	
}
