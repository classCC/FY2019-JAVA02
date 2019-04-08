package com.wz.view.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;

import com.wz.pojo.Admin;
import com.wz.pojo.Student;
import com.wz.view.View;
import com.wz.service.impl.ServiceImpl;

public class ViewImpl implements View {

	//ServiceImpl start2=new ServiceImpl();
	ServiceImpl F2=ServiceImpl.getInstance();//����
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
		username =username.toLowerCase();//�����ִ�Сд
		System.out.print("���������룺");
		String password=sc.next();
		testt() ;
		password =password.toLowerCase();
		
		//�ж��û����������Ƿ����
		for(int i=0;i<admin.length;i++) {
			if(admin[i]==null) {
				continue;
			}
			if(username.equals(admin[i].username)&&password.equals(admin[i].password)) {
				System.out.println("----------------��ӭ��½ѧ����Ϣ����ϵͳ---------------");
			}else {
				System.out.println("�û������������������������������");
				login(admin);
			}
		}
	}
	/*@Override
	public void login(Map<String,String> hashMap) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("�������û�����");
		String username=sc.next();
		System.out.print("���������룺");
		String password=sc.next();
		
		//�ж��û����������Ƿ����
			if(hashMap==null) {
				continue;
			}
		Set<Map.Entry<String,String>> set=hashMap.entrySet();
		Iterator<Map.Entry<String,String>> it=set.iterator();
		
		while(it.hasNext()) {
			if(hashMap.isEmpty()) {
				continue;
			}
			if(username.equals(hashMap.get(username))&&password.equals(hashMap.get(password))) {
				System.out.println("---------------��ӭ��½ѧ����Ϣ����ϵͳ---------------");
			}else {
				System.out.println("�û������������������������������");
				login(hashMap);
			}
		}
	}*/

	
	//���ܲ˵�ѡ��
	@Override
	public void mainmenu(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		System.out.println("---------------��ѡ��Ҫ��������Ϣ��Ӧ����--------------");
		System.out.println("1.�鿴��Ϣ	2.�����Ϣ	3.ɾ����Ϣ	4.�޸���Ϣ	5.�˳�");
		System.out.println("-----------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("��ѡ��");
		int n=sc.nextInt();
		
		//�����ֵ������switchѭ��
		switch(n) {
		case 1://�鿴��Ϣ
			F2.checkmsg(/*student*/);
			mainmenu(/*student*/);
			break;
		case 2://�����Ϣ
			F2.addmsg(/*student*/);
			mainmenu(/*student*/);
			break;
		case 3://ɾ����Ϣ
			F2.deletemsg(/*student*/);
			mainmenu(/*student*/);
			break;
		case 4://�޸���Ϣ
			F2.changemsg(/*student*/);
			mainmenu(/*student*/);
			break;
		case 5://�˳�
			System.out.println("ϵͳ�˳��ɹ���");
			System.exit(0);//�˳�
			break;
		default:
			System.out.println("����������");
			mainmenu(/*student*/);
		}
	}
	
	public static boolean VerificationCode() {         //��֤��У��
		String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//��������0-9 �� ��Сд��ĸ
		char[] ch = new char[4]; //����һ���ַ��������ch ���� ��֤��
		for (int i = 0; i < 4; i++) {
			Random random = new Random();//����һ���µ������������
			int index = random.nextInt(string.length());//����[0,string.length)��Χ��intֵ    ���ã������±�
			ch[i] = string.charAt(index);//charAt() : ����ָ���������� char ֵ   ==�����浽�ַ��������ch����
		}
		//��char��������ת��ΪString���ͱ��浽result
		//String result = new String(ch);//����һ��ֱ��ʹ�ù��췽��      String(char[] value) ������һ���µ� String��ʹ���ʾ�ַ���������е�ǰ�������ַ����С�
		String result = String.valueOf(ch);//�������� String����   valueOf(char c) ������ char �������ַ�����ʾ��ʽ��
		System.out.print("��֤�룺");
		System.out.println(result);
		Scanner scan=new Scanner(System.in);
		System.out.print("��������֤��(�����ִ�Сд)��");
		String s=scan.next();
		if(s.equalsIgnoreCase(result)) {
			//System.out.println("��֤�ɹ�");
			return true;
		}else {
			//System.out.println("��֤ʧ��");
			return false;
		}
	}
	
	public static void testt() {
		if(!VerificationCode() ) {
			System.out.println("��֤���������������");
			testt();
		}
	}


}
