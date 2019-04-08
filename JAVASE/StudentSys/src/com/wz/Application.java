package com.wz;

import com.wz.Exception.LoginException;
import com.wz.Exception.RegisterException;
import com.wz.view.impl.ViewImpl;

public class Application {

	/*static Student[] student1=new Student[5];//定义一个数组用来存储学生信息
	static Student[] student2=new Student[5];*/
	public static void main(String[]args) {
		ViewImpl start1=new ViewImpl();
		//ServiceImpl start2=new ServiceImpl();
		start1.welcome();					//开始欢迎界
		start1.choicelogin();				//选择登陆
		start1.mainmenu();					//选择操作
	}
}
