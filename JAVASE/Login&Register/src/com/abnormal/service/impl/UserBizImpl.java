package com.abnormal.service.impl;

import com.abnormal.exception.LoginException;
import com.abnormal.exception.RegisterException;
import com.abnormal.pojo.User;
import com.abnormal.service.UserBiz;

public  class UserBizImpl implements UserBiz {
	
	//创建User类型数组，用来保存已注册的用户信息。
	private User[] users=new User[5];
	
	/*初始情况下，数组中保存的对象为以下两个：
		用户名  密码  真实姓名          电子邮件
		admin  admin  Administrator   admin@123.com
		tom    cat    tomcat          tomcat@cat.com*/
	
	public UserBizImpl() {
		
		User user1=new User("admin","admin","Administrator","admin@123.com");
		User user2=new User("tom","cat","tomcat","tomcat@cat.com");
		
		this.users[0]=user1;
		this.users[1]=user2;
		
	}

	@Override
	public void register(String username, String password, String password2, String name, String email)
			throws RegisterException {
		// TODO Auto-generated method stub

	}

	@Override
	public void login(String username, String password) throws LoginException {
		// TODO Auto-generated method stub

		//默认用户名不存在
		boolean usernameexists=false;
		for(int i=0;i<users.length;i++) {
			
			User user=users[i];
			if(user==null) {
				continue;
			}
			
			String _username=user.getUsername();
			String _password=user.getPassword();
			if(_username.equals(username)) {//如果用户名存在
				usernameexists=true;
				
				if(password.equals(_password)) {
					//登录成功
					System.out.println("登录成功!!!");
				}else {								
					//username 和password 不匹配
					throw new LoginException("用户名与密码不匹配"); 
				}
			}
			
		}
	
	
	
	
		if(!usernameexists) {		//用户名不存在
			
			throw new LoginException("用户名不存在");
		}
	
	}
	


	@Override
	public boolean isusernameexists(String username) throws LoginException {
		// TODO Auto-generated method stub
		
		
	for(int i=0;i<users.length;i++) {
			
			User user=users[i];
			if(user==null) {
				continue;
			}
			
			String _username=user.getUsername();
			
			if(_username.equals(username)) {//用户名存在
				
			   return true;
			}
			
		}
		
		 throw new LoginException("用户名不存在");
		
	}
}
