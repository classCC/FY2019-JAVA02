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
	
	//����admin����
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
		//�жϲ����Ƿ����
		if(username==null||username.equals("")) {
			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_NULL, "�û�������Ϊ��");
		}
		if(password==null||password.equals("")) {
			return ServerResponse.createServerResponseByFail(Const.PASSWORD_NOT_NULL, "���벻��Ϊ��");
		}
		
		//�ж��û����Ƿ����
		boolean isexistsusername=isusernameexists(username);
		
		if(isexistsusername) {
			Admin admin=admins.get(username);
			String _username=admin.getUsername();
			String _password=admin.getPassword();
			//�ж��û����������Ƿ����
			if(_username.equals(username)) {//�û�������
				
				if(_password.equals(password)) {//������֤�ɹ�����½
					
					return ServerResponse.createServerResponseBySuccess();
				}else {//�û������������
					
					return ServerResponse.createServerResponseByFail(Const.PASSWORD_ERROR, "�������");
				}
			}
		}else {
			return ServerResponse.createServerResponseByFail(Const.USERNAME_NOT_EXISTS, "�û���������");
			
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
