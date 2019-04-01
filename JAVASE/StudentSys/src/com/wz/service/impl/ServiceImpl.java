package com.wz.service.impl;

import java.util.Scanner;

import com.wz.pojo.Admin;
import com.wz.pojo.Student;
import com.wz.service.Service;
import com.wz.view.impl.ViewImpl;

public class ServiceImpl implements Service {

	//ViewImpl start1=new ViewImpl();�����ջ����쳣

	boolean x=false;
	//�鿴��Ϣ
	@Override
	public void checkmsg(Student[] student) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------ѧ����Ϣ����-----------------------------");
		System.out.println("حѧ��"+"\t" +"ح����"+"\t"+"ح�Ա�"+"\t"+"ح����"+"\t"+"ح�꼶"+"\t"+"حסַ"+"\t"+"ح��ϵ��ʽ"+"\t"+"ح����");	    	
		    for(int i=0;i<student.length;i++) {
		    	if(student[i]!=null) {		
					System.out.println("ح"+student[i].getId()+"\t" +"ح"+student[i].getName()
							+"\t"+"ح"+student[i].getSex()+"\t"+"ح"+student[i].getAge()+"\t"+"ح"
							+student[i].getGrade()+"\t"+"ح"+student[i].getAddress()+"\t"+"ح"
							+student[i].getPhone()+"\t"+"ح"+student[i].getEmail());	
		    	}continue;
		    }
		    System.out.println("--------------------------------------------------------------");	
		
	}

	//�����Ϣ
	@Override
	public void addmsg(Student[] student) {
		// TODO Auto-generated method stub
		System.out.println("---------------��ѡ��Ҫ��������Ϣ��Ӧ����---------------");
		Scanner sc=new Scanner(System.in);
		int studentid;
		//�ж�����Ҫ�������ֲ���
		while(true) {
			System.out.print("������ѧ�ţ�");
			studentid=sc.nextInt();
			boolean judge=false;
			for(int i=0;i<student.length;i++) {
				if(student[i]==null) {
					continue;
				}
				if(student[i].getId()==studentid) {		
					judge = true;			
					break;
				}else {
					judge = false;			
					break;
				}
			}
			if(judge) {
				System.out.println("��������˺��Ѵ���");
			}else {
				break;
			}
		}
		
		System.out.print("������ѧ��������");
		String name1=sc.next();
		//sc.nextLine();
		System.out.print("������ѧ���Ա�");
		String sex1=sc.next();
		System.out.print("������ѧ�����䣺");
		int age1=sc.nextInt();
		System.out.print("������ѧ���꼶��");
		String grade1=sc.next();
		System.out.print("������ѧ����ַ��");
		String address1=sc.next();
		System.out.print("������ѧ���ֻ��ţ�");
		int phone1=sc.nextInt();
		System.out.print("������ѧ�����䣺");
		String email1=sc.next();
		
		//����ѧ������
		Student s = new Student();
		s.setId(studentid);
		s.setName(name1);
		s.setSex(sex1);
		s.setAge(age1);
		s.setGrade(grade1);
		s.setAddress(address1);
		s.setPhone(phone1);
		s.setEmail(email1);
		
		//��ѧ��������ӵ�����
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				student[i]=s;	
				break;
			}
		}
		System.out.println("��ӳɹ���");
		System.out.println("ϵͳ�Զ�������һ��......");
	}

	//ɾ����Ϣ
	@Override
	public void deletemsg(Student[] student,Student[] student1) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("��������Ҫɾ����ѧ��ID:");
		int nid=sc.nextInt();
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;	
			}
			if(student[i].getId()==nid) {
				System.out.println("��Ҫɾ����ѧ����Ϣ����:");	
				System.out.println("ح"+student[i].getId()+"\t" +"ح"+student[i].getName()
						+"\t"+"ح"+student[i].getSex()+"\t"+"ح"+student[i].getAge()
						+"\t"+"ح"+student[i].getGrade()+"\t"+"ح"+student[i].getAddress()
						+"\t"+"ح"+student[i].getPhone()+"\t"+"ح"+student[i].getEmail());	
				System.out.println("��ȷ���Ƿ�ɾ��:1.��	2.�� ");
				System.out.print("������:");
				int nid1=sc.nextInt();
				if(nid1==1) {
					for(int j=0;j<student.length;j++) {
						if(student[j]==null) {
							continue;
						}
						if(student[i].getId()!=student[j].getId()) {
							Student s=new Student(student[j].getId(),student[j].getName(),
									student[j].getAge(),student[j].getSex(),student[j].getGrade(),
									student[j].getAddress(),student[j].getPhone(),student[j].getEmail());
							for(int k=0;k<student1.length;k++) {
								if(student1[k]==null) {
									student1[k]=s;
									break;
								}
							}
						}
					}
					System.arraycopy(student1, 0, student, 0, student1.length);//student=student1;
					System.out.println("ɾ���ɹ�");	
					break;
				}else if(nid1==2) {
					System.out.println("ȡ��");	
					break;
				}else {
					System.out.println("����������");
					deletemsg(student,student1); 
					break;
				}
			}else {
				x=true;
			}
		}
		if(x==true) {
			System.out.println("��Ҫɾ����ѧ��������");	
			deletemsg(student,student1);
		}
		
	}
				

	//�޸���Ϣ
	@Override
	public void changemsg(Student[] student) {
		// TODO Auto-generated method stub
		System.out.println("---------------��ѡ��Ҫ��������Ϣ��Ӧ����---------------");
		System.out.println("1.�޸�ȫ����Ϣ          2.�޸Ĳ�����Ϣ          3.�����ϼ�Ŀ¼          4.ϵͳ�˳�");
		System.out.println("-----------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("��ѡ��");
		int n=sc.nextInt();
		if(n==1) {					
			//����ID�޸�ѧ��ȫ����Ϣ
			changeall(student);
			}else if(n==2) {
			//����ID�޸�ѧ��������Ϣ
			changesome(student);
			}else if(n==3) {
			//mainmenu(student);    //�����ϼ�Ŀ¼
			}else if(n==4){
			System.out.println("ϵͳ�˳��ɹ���");
			System.exit(0);			//�˳�
			}else {
				System.out.println("����������");	
				changemsg(student);
			}
	}

	//�޸�ȫ��
	@Override
	public void changeall(Student[] student) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("������Ҫ�޸ĵ�id��");
		int id=sc.nextInt();
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;
			}
			x=false;
			if(student[i].getId()==id) {
				System.out.println("Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("ح"+student[i].getId()+"\t" +"ح"+student[i].getName()+"\t"+"ح"
						+student[i].getSex()+"\t"+"ح"+student[i].getAge()+"\t"+"ح"+student[i].getGrade()+"\t"+"ح"
						+student[i].getAddress()+"\t"+"ح"+student[i].getPhone()+"\t"+"ح"+student[i].getEmail());
				System.out.print("�������޸ĺ��������");
				String name=sc.next();
				student[i].setName(name);
				System.out.print("�������޸ĺ���Ա�");
				String sex=sc.next();
				student[i].setSex(sex);
				System.out.print("�������޸ĺ�����䣺");
				int age=sc.nextInt();
				student[i].setAge(age);
				System.out.print("�������޸ĺ���꼶��");
				String grade=sc.next();
				student[i].setGrade(grade);
				System.out.print("�������޸ĺ�ĵ�ַ��");
				String address=sc.next();
				student[i].setAddress(address);
				System.out.print("�������޸ĺ���ֻ��ţ�");
				int phone=sc.nextInt();
				student[i].setPhone(phone);
				System.out.print("�������޸ĺ�����䣺");
				String email=sc.next();
				student[i].setEmail(email);
				System.out.println("�޸ĳɹ����Զ�������һ��......");
				changemsg(student);
				break;	
			}else {
				x=true;
			}
		}
		if(x==true) {
			System.out.println("��ID�����ڣ�����������");
			changeall(student);
		}
	}

	//�޸Ĳ���
	@Override
	public void changesome(Student[] student) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("������Ҫ�޸ĵ�id��");
		int id=sc.nextInt();
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;
			}
			x=false;
			if(student[i].getId()==id) {
				System.out.println("��Ҫ�޸ĵ�ѧ����Ϣ����:");	
				System.out.println("ح"+student[i].getId()+"\t" +"ح"+student[i].getName()+"\t"+"ح"
						+student[i].getSex()+"\t"+"ح"+student[i].getAge()+"\t"+"ح"+student[i].getGrade()+"\t"+"ح"
						+student[i].getAddress()+"\t"+"ح"+student[i].getPhone()+"\t"+"ح"+student[i].getEmail());
				System.out.println("������Ҫ�޸ĵ����ԣ�");	 
				String t3=sc.next();
				System.out.println("�������޸ĺ��ֵ��");	 
				String t4=sc.next();
				if(t3.equals("name")) {
					student[i].setName(t4);
				}else if(t3.equals("sex")) {
					student[i].setSex(t4);
				}else if(t3.equals("age")) {
					student[i].setAge(Integer.valueOf(t4));
				}else if(t3.equals("grade")) {
					student[i].setGrade(t4);
				}else if(t3.equals("addr")) {
					student[i].setAddress(t4);
				}else if(t3.equals("phone")) {
					student[i].setPhone(Integer.valueOf(t4));
				}else if(t3.equals("email")) {
					student[i].setEmail(t4);
				}
				System.out.println("�޸ĳɹ����Զ�������һ��......");
				changemsg(student);
				break;	
			}else {
				x=true;
			}
	
		}
		if(x==true) {
		System.out.println("��ID������!!!");
		changesome(student);
		}
	}


}
