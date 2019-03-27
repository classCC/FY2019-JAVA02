package com.abnormal.service.impl;

import com.abnormal.exception.LoginException;
import com.abnormal.exception.RegisterException;
import com.abnormal.pojo.User;
import com.abnormal.service.UserBiz;

public  class UserBizImpl implements UserBiz {
	
	//����User�������飬����������ע����û���Ϣ��
	private User[] users=new User[5];
	
	/*��ʼ����£������б���Ķ���Ϊ����������
		�û���  ����  ��ʵ����          �����ʼ�
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

		//Ĭ���û���������
		boolean usernameexists=false;
		for(int i=0;i<users.length;i++) {
			
			User user=users[i];
			if(user==null) {
				continue;
			}
			
			String _username=user.getUsername();
			String _password=user.getPassword();
			if(_username.equals(username)) {//����û�������
				usernameexists=true;
				
				if(password.equals(_password)) {
					//��¼�ɹ�
					System.out.println("��¼�ɹ�!!!");
				}else {								
					//username ��password ��ƥ��
					throw new LoginException("�û��������벻ƥ��"); 
				}
			}
			
		}
	
	
	
	
		if(!usernameexists) {		//�û���������
			
			throw new LoginException("�û���������");
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
			
			if(_username.equals(username)) {//�û�������
				
			   return true;
			}
			
		}
		
		 throw new LoginException("�û���������");
		
	}
}
