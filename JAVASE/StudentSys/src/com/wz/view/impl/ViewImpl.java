package com.wz.view.impl;

import java.util.Scanner;

import com.wz.pojo.Admin;
import com.wz.pojo.Student;
import com.wz.view.View;
import com.wz.service.impl.ServiceImpl;

public class ViewImpl implements View {

	ServiceImpl start2=new ServiceImpl();
	//��ӭ����
	@Override
	public void welcome() {
		// TODO Auto-generated method stub
		System.out.println("---------------��ӭʹ��ѧ����Ϣ����ϵͳ---------------");
		System.out.println("1.��½		2.�˳�");
		System.out.println("----------------------------------------------");
	}
	
	//ѡ���½
	@Override
	public void choicelogin() {
		// TODO Auto-generated method stub
		Admin[] admin=new Admin[2];			//����һ������Ϊ����admin����
		Admin a=new Admin("admin","admin");	//����һ���û�admin������admin
		admin[0]=a;							//��a���浽admin�ĵ�һ������
		Scanner sc=new Scanner(System.in);
		System.out.print("��ѡ��");
		int n=sc.nextInt();
		if(n==1) {
			login(admin);
		}else if(n==2) {
			System.out.print("����˳�");
			System.exit(0);					//�˳�����
		}else {
			System.out.print("����������");
			choicelogin();					//�ݹ����
		}
	}

	//�����û���Ϣ
	@Override
	public void login(Admin[] admin) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("�������û�����");
		String username=sc.next();
		System.out.print("���������룺");
		String password=sc.next();
		
		//�ж��û����������Ƿ����
		for(int i=0;i<admin.length;i++) {
			if(admin[i]==null) {
				continue;
			}
			if(username.equals(admin[i].username)&&password.equals(admin[i].password)) {
				System.out.println("---------------��ӭ��½ѧ����Ϣ����ϵͳ---------------");
			}else {
				System.out.println("�û������������������������������");
				login(admin);
			}
		}
	}
	
	//���ܲ˵�ѡ��
	@Override
	public void mainmenu(Student[]student1,Student[]student2) {
		// TODO Auto-generated method stub
		System.out.println("---------------��ѡ��Ҫ��������Ϣ��Ӧ����---------------");
		System.out.println("1.�鿴��Ϣ          2.�����Ϣ          3.ɾ����Ϣ          4.�޸���Ϣ          5.�˳�");
		System.out.println("-----------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("��ѡ��");
		int n=sc.nextInt();
		
		//�����ֵ������switchѭ��
		switch(n) {
		case 1://�鿴��Ϣ
			start2.checkmsg(student1);
			mainmenu(student1, student2);
			
		case 2://�����Ϣ
			start2.addmsg(student1);
			mainmenu(student1, student2);
			
		case 3://ɾ����Ϣ
			start2.deletemsg(student1,student2);
			mainmenu(student1, student2);
			
		case 4://�޸���Ϣ
			start2.changemsg(student1);
			mainmenu(student1, student2);
			
		case 5://�˳�
			System.out.println("ϵͳ�˳��ɹ���");
			mainmenu(student1, student2);
		default:
			System.out.println("����������");
			mainmenu(student1,student2);
		}
	}


}
