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
	ServiceImpl F2=ServiceImpl.getInstance();//单例
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
		username =username.toLowerCase();//不区分大小写
		System.out.print("请输入密码：");
		String password=sc.next();
		testt() ;
		password =password.toLowerCase();
		
		//判断用户名与密码是否存在
		for(int i=0;i<admin.length;i++) {
			if(admin[i]==null) {
				continue;
			}
			if(username.equals(admin[i].username)&&password.equals(admin[i].password)) {
				System.out.println("----------------欢迎登陆学生信息管理系统---------------");
			}else {
				System.out.println("用户名错误或密码输入有误，请重新输入");
				login(admin);
			}
		}
	}
	/*@Override
	public void login(Map<String,String> hashMap) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.print("请输入用户名：");
		String username=sc.next();
		System.out.print("请输入密码：");
		String password=sc.next();
		
		//判断用户名与密码是否存在
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
				System.out.println("---------------欢迎登陆学生信息管理系统---------------");
			}else {
				System.out.println("用户名错误或密码输入有误，请重新输入");
				login(hashMap);
			}
		}
	}*/

	
	//功能菜单选择
	@Override
	public void mainmenu(/*List<Student> student*/) {
		// TODO Auto-generated method stub
		System.out.println("---------------请选择要操作的信息对应数字--------------");
		System.out.println("1.查看信息	2.添加信息	3.删除信息	4.修改信息	5.退出");
		System.out.println("-----------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("请选择：");
		int n=sc.nextInt();
		
		//输入的值来进行switch循环
		switch(n) {
		case 1://查看信息
			F2.checkmsg(/*student*/);
			mainmenu(/*student*/);
			break;
		case 2://添加信息
			F2.addmsg(/*student*/);
			mainmenu(/*student*/);
			break;
		case 3://删除信息
			F2.deletemsg(/*student*/);
			mainmenu(/*student*/);
			break;
		case 4://修改信息
			F2.changemsg(/*student*/);
			mainmenu(/*student*/);
			break;
		case 5://退出
			System.out.println("系统退出成功！");
			System.exit(0);//退出
			break;
		default:
			System.out.println("请重新输入");
			mainmenu(/*student*/);
		}
	}
	
	public static boolean VerificationCode() {         //验证码校验
		String string = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";//保存数字0-9 和 大小写字母
		char[] ch = new char[4]; //声明一个字符数组对象ch 保存 验证码
		for (int i = 0; i < 4; i++) {
			Random random = new Random();//创建一个新的随机数生成器
			int index = random.nextInt(string.length());//返回[0,string.length)范围的int值    作用：保存下标
			ch[i] = string.charAt(index);//charAt() : 返回指定索引处的 char 值   ==》保存到字符数组对象ch里面
		}
		//将char数组类型转换为String类型保存到result
		//String result = new String(ch);//方法一：直接使用构造方法      String(char[] value) ：分配一个新的 String，使其表示字符数组参数中当前包含的字符序列。
		String result = String.valueOf(ch);//方法二： String方法   valueOf(char c) ：返回 char 参数的字符串表示形式。
		System.out.print("验证码：");
		System.out.println(result);
		Scanner scan=new Scanner(System.in);
		System.out.print("请输入验证码(不区分大小写)：");
		String s=scan.next();
		if(s.equalsIgnoreCase(result)) {
			//System.out.println("验证成功");
			return true;
		}else {
			//System.out.println("验证失败");
			return false;
		}
	}
	
	public static void testt() {
		if(!VerificationCode() ) {
			System.out.println("验证码错误！请重新输入");
			testt();
		}
	}


}
