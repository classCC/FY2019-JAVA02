package com.wz;

import com.wz.pojo.Student;
import com.wz.Exception.LoginException;
import com.wz.Exception.RegisterException;
import com.wz.pojo.Admin;
import com.wz.service.impl.ServiceImpl;
import com.wz.view.impl.ViewImpl;

public class Application {

	static Student[] student1=new Student[5];//����һ�����������洢ѧ����Ϣ
	static Student[] student2=new Student[5];
	public static void main(String[]args) {
		ViewImpl start1=new ViewImpl();
		//ServiceImpl start2=new ServiceImpl();
		start1.welcome();					//��ʼ��ӭ����
		try {
			start1.choicelogin();				//ѡ���½
			start1.mainmenu(student1, student2);//ѡ�����
		}catch(LoginException e) {
			System.out.print("��½����");
		}catch(RegisterException e) {
			System.out.print("��������");
		}	
	}
}
