package com.neuedu.view.impl;

import java.util.Scanner;

import com.neuedu.pojo.Admin;
import com.neuedu.view.UserView;

public class UserViewImpl implements UserView {

	public void login1(Admin[] admins) {
		// TODO Auto-generated method stub
		System.out.println("��ӭ ��½��");
		
		Scanner s=new Scanner(System.in);
		System.out.println("�������û���");
		String username=s.nextLine();
		System.out.println("����������");
		String password=s.nextLine();
		for(int i=0;i<admins.length;i++){
			Admin admin=admins[i];
			
			if(admin==null){
				continue;
			}else if(username.equals(admin.getUsername()) && password.equals(admin.getPassword())){
				System.out.println("��ӭ��"+username);
				operation();
				break;
			}else {
				System.out.println("�����������������롣");
				login1(admins);
			}
		}
	}
	
	public void operation() {
		System.out.println("***************��ѡ��Ҫ��������Ϣ��Ӧ������**************");
		System.out.println("*1.�鿴ѧ����Ϣ 2.���ѧ����Ϣ 3.ɾ��ѧ����Ϣ 4.�޸�ѧ����Ϣ 5.�˳�*");
		System.out.println("************************************************");
		Scanner s=new Scanner(System.in);
		System.out.println("��ѡ��");
		int operation=s.nextInt();
		
		if(operation==1) {
			
		}else if(operation==2) {
			addto();
		}else if(operation==3) {
			
		}else if(operation==4) {
			
		}else if(operation==5) {
			
		}else {
			System.out.println("�����������������롣");
			operation();
		}
	}
	
	@Override
	public void login(Admin[] admins) {
		// TODO Auto-generated method stub
		
		//���ܼ��������ȡusername,password
		Scanner s=new Scanner(System.in);
		System.out.println("��ѡ��");
		int login=s.nextInt();
		
		if(login==1) {
			//��½
			login1(admins);
		}else if(login==2){
			//�˳�
		}else {
			System.out.println("�����������������롣");
			login(admins);
		}
	}
	
	
	@Override
	public void addto() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void change() {
		// TODO Auto-generated method stub
		
	}


	
	

}
