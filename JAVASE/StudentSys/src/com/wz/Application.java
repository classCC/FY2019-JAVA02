package com.wz;

import com.wz.Exception.LoginException;
import com.wz.Exception.RegisterException;
import com.wz.view.impl.ViewImpl;

public class Application {

	/*static Student[] student1=new Student[5];//����һ�����������洢ѧ����Ϣ
	static Student[] student2=new Student[5];*/
	public static void main(String[]args) {
		ViewImpl start1=new ViewImpl();
		//ServiceImpl start2=new ServiceImpl();
		start1.welcome();					//��ʼ��ӭ��
		start1.choicelogin();				//ѡ���½
		start1.mainmenu();					//ѡ�����
	}
}
