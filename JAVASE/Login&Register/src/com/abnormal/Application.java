package com.abnormal;

import java.util.Scanner;

import com.abnormal.Application;
import com.abnormal.exception.LoginException;
import com.abnormal.view.UserView;
import com.abnormal.view.impl.UserViewImpl;

public class Application {

	UserView userView=new UserViewImpl();
	public static void main(String[]args) {
		 //step1: 
		Application app=new Application();
		app.choise();
	}
	
	
	public void  choise() {
		
		System.out.println("====��ӭ���ʼƷ�ϵͳ===");
		Scanner s=new Scanner(System.in);
		System.out.println("====������ 1:��¼ 2:ע��===");
		int num=s.nextInt();
		
		if(num==1) {//��¼
			
			try {
				
				userView.login();
			} catch (LoginException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();//��ӡ��ջ��Ϣ
				
				String msg=e.getMessage();
				System.out.print(msg);
				
			}
			
		}else  if(num==2){
			//ע��
			
		}
		
		
	}
	
}
