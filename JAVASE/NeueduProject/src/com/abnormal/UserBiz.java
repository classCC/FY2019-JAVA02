package com.abnormal;

public interface UserBiz {

	//�û�ע��
	void register(String username, String password, 
			String password2,String name, String email) throws RegisterException;
	
	//�û���¼
	void login(String username, String password) throws LoginException;
	
	
}
