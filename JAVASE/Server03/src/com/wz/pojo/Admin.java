package com.wz.pojo;

public class Admin {

	public String username;//����username����
	public String password;//����password����
	
	//����Admin��ʼ�����������
	public Admin(String username,String password){
		super();
		this.username=username;
		this.password=password;
	}
	
	
	public Admin(){
		
	}

	//get�����������ø���ʱ����Ϣ�������set�����͸������ø���ʱ���û�����
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
