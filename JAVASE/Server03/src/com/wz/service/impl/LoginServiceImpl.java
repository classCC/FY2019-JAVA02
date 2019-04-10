package com.wz.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.wz.common.Const;
import com.wz.common.ServerResponse;
import com.wz.pojo.Admin;
import com.wz.service.ILoginService;

public class LoginServiceImpl implements ILoginService {

	private static LoginServiceImpl instance;
	
	//创建admin集合
	//List<Admin> admins=new ArrayList<Admin>();
	Map<String,Admin> admins=new HashMap<String,Admin>();
	
	private LoginServiceImpl() {
		Admin user1=new Admin("admin","admin");
		//admins.add(user1);
		admins.put(user1.getUsername(), user1);
	}
	
	public static synchronized LoginServiceImpl getInstance() {
		if(instance==null) {
			instance=new LoginServiceImpl();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ServerResponse<Admin> login(String username, String password) {
		// TODO Auto-generated method stub
		//判断参数是否存在
		if(username==null||username.equals("")) {
			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_NULL, "用户名不能为空");
		}
		if(password==null||password.equals("")) {
			return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_NULL, "密码不能为空");
		}
		
		//判断用户名是否存在
		boolean isexistsusername=isusernameexists(username);
		
		if(isexistsusername) {
			Admin admin=admins.get(username);
			String _username=admin.getUsername();
			String _password=admin.getPassword();
			//判断用户名与密码是否存在
			if(_username.equals(username)) {//用户名存在
				
				if(_password.equals(password)) {//密码验证成功，登陆
					
					return ServerResponse.createServerResponseBySuccess();
				}else {//用户名或密码错误
					
					return ServerResponse.createServerResponseByFail(Const.PASSWORD_ERROR, "密码错误");
				}
			}
		}else {
			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_EXISTS, "用户名不存在");
			
		}
		
		
		return null;
	}
	public boolean isusernameexists(String username) {
		
		/*for(int i=0;i<admin.size();i++) {
			
			Admin user=admin.get(i);
			if(user==null) {
				continue;
			}
			String _username=user.getUsername();
			if(_username.equals(username)) {
				return true;
			}
		}
		
		return false;*/
		return admins.containsKey(username);
	}

}
