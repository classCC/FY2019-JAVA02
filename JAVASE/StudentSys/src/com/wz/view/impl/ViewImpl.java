package com.wz.view.impl;

import java.util.Scanner;

import com.wz.pojo.Admin;
import com.wz.pojo.Student;
import com.wz.view.View;
import com.wz.service.impl.ServiceImpl;

public class ViewImpl implements View {

	ServiceImpl start2=new ServiceImpl();
	//欢迎界面
	@Override
	public void welcome() {
		// TODO Auto-generated method stub
		System.out.println("---------------欢迎使用学生信息管理系统---------------");
		System.out.println("1.登陆		2.退出");
		System.out.println("----------------------------------------------");
	}
	
	//选择登陆
	@Override
	public void choicelogin() {
		// TODO Auto-generated method stub
		Admin[] admin=new Admin[2];			//定义一个长度为二的admin数组
		Admin a=new Admin("admin","admin");	//定义一个用户admin，密码admin
		admin[0]=a;							//把a保存到admin的第一个数组
		Scanner sc=new Scanner(System.in);
		System.out.print("请选择：");
		int n=sc.nextInt();
		if(n==1) {
			login(admin);
		}else if(n==2) {
			System.out.print("完成退出");
			System.exit(0);					//退出操作
		}else {
			System.out.print("请重新输入");
			choicelogin();					//递归调用
		}
	}

	//输入用户信息
	@Override
	public void login(Admin[] admin) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入用户名：");
		String username=sc.next();
		System.out.print("请输入密码：");
		String password=sc.next();
		
		//判断用户名与密码是否存在
		for(int i=0;i<admin.length;i++) {
			if(admin[i]==null) {
				continue;
			}
			if(username.equals(admin[i].username)&&password.equals(admin[i].password)) {
				System.out.println("---------------欢迎登陆学生信息管理系统---------------");
			}else {
				System.out.println("用户名错误或密码输入有误，请重新输入");
				login(admin);
			}
		}
	}
	
	//功能菜单选择
	@Override
	public void mainmenu(Student[]student1,Student[]student2) {
		// TODO Auto-generated method stub
		System.out.println("---------------请选择要操作的信息对应数字---------------");
		System.out.println("1.查看信息          2.添加信息          3.删除信息          4.修改信息          5.退出");
		System.out.println("-----------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("请选择：");
		int n=sc.nextInt();
		
		//输入的值来进行switch循环
		switch(n) {
		case 1://查看信息
			start2.checkmsg(student1);
			mainmenu(student1, student2);
			
		case 2://添加信息
			start2.addmsg(student1);
			mainmenu(student1, student2);
			
		case 3://删除信息
			start2.deletemsg(student1,student2);
			mainmenu(student1, student2);
			
		case 4://修改信息
			start2.changemsg(student1);
			mainmenu(student1, student2);
			
		case 5://退出
			System.out.println("系统退出成功！");
			mainmenu(student1, student2);
		default:
			System.out.println("请重新输入");
			mainmenu(student1,student2);
		}
	}


}
