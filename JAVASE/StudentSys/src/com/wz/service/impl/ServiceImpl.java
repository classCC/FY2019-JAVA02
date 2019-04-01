package com.wz.service.impl;

import java.util.Scanner;

import com.wz.pojo.Admin;
import com.wz.pojo.Student;
import com.wz.service.Service;
import com.wz.view.impl.ViewImpl;

public class ServiceImpl implements Service {

	//ViewImpl start1=new ViewImpl();会出现栈溢出异常

	boolean x=false;
	//查看信息
	@Override
	public void checkmsg(Student[] student) {
		// TODO Auto-generated method stub
		System.out.println("-------------------------学生信息如下-----------------------------");
		System.out.println("丨学号"+"\t" +"丨姓名"+"\t"+"丨性别"+"\t"+"丨年龄"+"\t"+"丨年级"+"\t"+"丨住址"+"\t"+"丨联系方式"+"\t"+"丨邮箱");	    	
		    for(int i=0;i<student.length;i++) {
		    	if(student[i]!=null) {		
					System.out.println("丨"+student[i].getId()+"\t" +"丨"+student[i].getName()
							+"\t"+"丨"+student[i].getSex()+"\t"+"丨"+student[i].getAge()+"\t"+"丨"
							+student[i].getGrade()+"\t"+"丨"+student[i].getAddress()+"\t"+"丨"
							+student[i].getPhone()+"\t"+"丨"+student[i].getEmail());	
		    	}continue;
		    }
		    System.out.println("--------------------------------------------------------------");	
		
	}

	//添加信息
	@Override
	public void addmsg(Student[] student) {
		// TODO Auto-generated method stub
		System.out.println("---------------请选择要操作的信息对应数字---------------");
		Scanner sc=new Scanner(System.in);
		int studentid;
		//判断输入要进行哪种操作
		while(true) {
			System.out.print("请输入学号：");
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
				System.out.println("您输入的账号已存在");
			}else {
				break;
			}
		}
		
		System.out.print("请输入学生姓名：");
		String name1=sc.next();
		//sc.nextLine();
		System.out.print("请输入学生性别：");
		String sex1=sc.next();
		System.out.print("请输入学生年龄：");
		int age1=sc.nextInt();
		System.out.print("请输入学生年级：");
		String grade1=sc.next();
		System.out.print("请输入学生地址：");
		String address1=sc.next();
		System.out.print("请输入学生手机号：");
		int phone1=sc.nextInt();
		System.out.print("请输入学生邮箱：");
		String email1=sc.next();
		
		//创建学生对象
		Student s = new Student();
		s.setId(studentid);
		s.setName(name1);
		s.setSex(sex1);
		s.setAge(age1);
		s.setGrade(grade1);
		s.setAddress(address1);
		s.setPhone(phone1);
		s.setEmail(email1);
		
		//把学生对象添加到集合
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				student[i]=s;	
				break;
			}
		}
		System.out.println("添加成功！");
		System.out.println("系统自动返回上一级......");
	}

	//删除信息
	@Override
	public void deletemsg(Student[] student,Student[] student1) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入您要删除的学生ID:");
		int nid=sc.nextInt();
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;	
			}
			if(student[i].getId()==nid) {
				System.out.println("您要删除的学生信息如下:");	
				System.out.println("丨"+student[i].getId()+"\t" +"丨"+student[i].getName()
						+"\t"+"丨"+student[i].getSex()+"\t"+"丨"+student[i].getAge()
						+"\t"+"丨"+student[i].getGrade()+"\t"+"丨"+student[i].getAddress()
						+"\t"+"丨"+student[i].getPhone()+"\t"+"丨"+student[i].getEmail());	
				System.out.println("请确认是否删除:1.是	2.否 ");
				System.out.print("请输入:");
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
					System.out.println("删除成功");	
					break;
				}else if(nid1==2) {
					System.out.println("取消");	
					break;
				}else {
					System.out.println("请重新输入");
					deletemsg(student,student1); 
					break;
				}
			}else {
				x=true;
			}
		}
		if(x==true) {
			System.out.println("您要删除的学生不存在");	
			deletemsg(student,student1);
		}
		
	}
				

	//修改信息
	@Override
	public void changemsg(Student[] student) {
		// TODO Auto-generated method stub
		System.out.println("---------------请选择要操作的信息对应数字---------------");
		System.out.println("1.修改全部信息          2.修改部分信息          3.返回上级目录          4.系统退出");
		System.out.println("-----------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("请选择：");
		int n=sc.nextInt();
		if(n==1) {					
			//根据ID修改学生全部信息
			changeall(student);
			}else if(n==2) {
			//根据ID修改学生部分信息
			changesome(student);
			}else if(n==3) {
			//mainmenu(student);    //返回上级目录
			}else if(n==4){
			System.out.println("系统退出成功！");
			System.exit(0);			//退出
			}else {
				System.out.println("请重新输入");	
				changemsg(student);
			}
	}

	//修改全部
	@Override
	public void changeall(Student[] student) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入要修改的id：");
		int id=sc.nextInt();
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;
			}
			x=false;
			if(student[i].getId()==id) {
				System.out.println("要修改的学生信息如下:");	
				System.out.println("丨"+student[i].getId()+"\t" +"丨"+student[i].getName()+"\t"+"丨"
						+student[i].getSex()+"\t"+"丨"+student[i].getAge()+"\t"+"丨"+student[i].getGrade()+"\t"+"丨"
						+student[i].getAddress()+"\t"+"丨"+student[i].getPhone()+"\t"+"丨"+student[i].getEmail());
				System.out.print("请输入修改后的姓名：");
				String name=sc.next();
				student[i].setName(name);
				System.out.print("请输入修改后的性别：");
				String sex=sc.next();
				student[i].setSex(sex);
				System.out.print("请输入修改后的年龄：");
				int age=sc.nextInt();
				student[i].setAge(age);
				System.out.print("请输入修改后的年级：");
				String grade=sc.next();
				student[i].setGrade(grade);
				System.out.print("请输入修改后的地址：");
				String address=sc.next();
				student[i].setAddress(address);
				System.out.print("请输入修改后的手机号：");
				int phone=sc.nextInt();
				student[i].setPhone(phone);
				System.out.print("请输入修改后的邮箱：");
				String email=sc.next();
				student[i].setEmail(email);
				System.out.println("修改成功！自动返回上一级......");
				changemsg(student);
				break;	
			}else {
				x=true;
			}
		}
		if(x==true) {
			System.out.println("此ID不存在，请重新输入");
			changeall(student);
		}
	}

	//修改部分
	@Override
	public void changesome(Student[] student) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入要修改的id：");
		int id=sc.nextInt();
		for(int i=0;i<student.length;i++) {
			if(student[i]==null) {
				continue;
			}
			x=false;
			if(student[i].getId()==id) {
				System.out.println("您要修改的学生信息如下:");	
				System.out.println("丨"+student[i].getId()+"\t" +"丨"+student[i].getName()+"\t"+"丨"
						+student[i].getSex()+"\t"+"丨"+student[i].getAge()+"\t"+"丨"+student[i].getGrade()+"\t"+"丨"
						+student[i].getAddress()+"\t"+"丨"+student[i].getPhone()+"\t"+"丨"+student[i].getEmail());
				System.out.println("请输入要修改的属性：");	 
				String t3=sc.next();
				System.out.println("请输入修改后的值：");	 
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
				System.out.println("修改成功！自动返回上一级......");
				changemsg(student);
				break;	
			}else {
				x=true;
			}
	
		}
		if(x==true) {
		System.out.println("此ID不存在!!!");
		changesome(student);
		}
	}


}
