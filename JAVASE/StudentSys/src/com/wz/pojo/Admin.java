package com.wz.pojo;

//�������Ա��
public class Admin {

	public String username;//����username����
	public String password;//����password����
	
	//����Admin��ʼ�����������
	public Admin(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	//����һ�����������洢ϵͳ�û�
	public Admin(){
		Admin[] admin=new Admin[2];			//����һ������Ϊ����admin����
		Admin a=new Admin("admin","admin");	//����һ���û�admin������admin��
		admin[0]=a;							//��a���浽admin�ĵ�һ������
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
